#!/bin/bash
#
# auto-push.sh — commit and push any local changes in this repo.
# Run on a schedule by ~/Library/LaunchAgents/com.ai-bearing.autopush.plist
#
set -euo pipefail

REPO="/Users/ai-bearing/Documents/GitHub/ai-bearing.github.io"
BRANCH="main"
LOG="$HOME/Library/Logs/auto-push.log"
MARKER="$HOME/Library/Logs/auto-push.FAILED"

# Make sure git (and its credential helper) are found in launchd's minimal PATH.
export PATH="/usr/bin:/usr/local/bin:/opt/homebrew/bin:$PATH"
export GIT_TERMINAL_PROMPT=0   # never block on an auth prompt

log() { echo "[$(date '+%Y-%m-%d %H:%M:%S')] $*" >>"$LOG"; }

# On failure: pop a Notification Center alert and drop a marker file so the
# failure is visible even if the alert is missed.
fail() {
    local msg="$1"
    log "ERROR: $msg"
    echo "[$(date '+%Y-%m-%d %H:%M:%S')] $msg (see $LOG)" >"$MARKER"
    osascript -e "display notification \"$msg\" with title \"Auto-push FAILED\" sound name \"Basso\"" >/dev/null 2>&1 || true
    exit 1
}

# Clear a stale marker from a previous failure once things are healthy again.
clear_marker() { [ -f "$MARKER" ] && rm -f "$MARKER"; }

cd "$REPO" || fail "repo not found at $REPO"

# Nothing staged, unstaged, or untracked? Then there is nothing to do.
if [ -z "$(git status --porcelain)" ]; then
    log "No changes — nothing to push."
    clear_marker
    exit 0
fi

git add -A || fail "git add failed"

git commit -m "Auto-commit: $(date '+%Y-%m-%d %H:%M:%S')" >>"$LOG" 2>&1 \
    || fail "commit failed"

git push origin "$BRANCH" >>"$LOG" 2>&1 \
    || fail "commit succeeded but push failed"

log "Pushed changes to origin/$BRANCH."
clear_marker
