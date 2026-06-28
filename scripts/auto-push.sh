#!/bin/bash
#
# auto-push.sh — commit and push any local changes in this repo.
# Run on a schedule by ~/Library/LaunchAgents/com.ai-bearing.autopush.plist
#
set -euo pipefail

REPO="/Users/ai-bearing/Documents/GitHub/ai-bearing.github.io"
BRANCH="main"
LOG="$HOME/Library/Logs/auto-push.log"

# Make sure git (and its credential helper) are found in launchd's minimal PATH.
export PATH="/usr/bin:/usr/local/bin:/opt/homebrew/bin:$PATH"
export GIT_TERMINAL_PROMPT=0   # never block on an auth prompt

log() { echo "[$(date '+%Y-%m-%d %H:%M:%S')] $*" >>"$LOG"; }

cd "$REPO" || { log "ERROR: repo not found at $REPO"; exit 1; }

# Nothing staged, unstaged, or untracked? Then there is nothing to do.
if [ -z "$(git status --porcelain)" ]; then
    log "No changes — nothing to push."
    exit 0
fi

git add -A

if git commit -m "Auto-commit: $(date '+%Y-%m-%d %H:%M:%S')" >>"$LOG" 2>&1; then
    if git push origin "$BRANCH" >>"$LOG" 2>&1; then
        log "Pushed changes to origin/$BRANCH."
    else
        log "ERROR: commit succeeded but push failed (see above)."
        exit 1
    fi
else
    log "ERROR: commit failed (see above)."
    exit 1
fi
