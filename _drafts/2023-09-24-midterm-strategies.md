---
layout: post
title: "Midterm Strategies"
permalink: "/posts/midterm_strategies.html"
use_math: true
---
Midterms are coming up! My first one is on Thursday, September 28, in Game Theory. I'm going to be making a bunch of mental notes on what to do when the midterm arrives.

## Finding Nash Equilibria in Two-Player Games:

1. Iteratively Eliminate Strictly Dominated Strategies (remembering to use mixing with the strategies).
 - The requirement for IESDS is a *strict* greater than, not simply greater than or equal to, unlike the Nash equilibrium.
2. After IESDS, if one strategy profile survives, that strategy profile is the Nash equilibrium.
3. Only after IESDS can one start using the methods of finding mixed strategy Nash equilibria (solving linear equations, using the best response correspondences, etc.)

## Proving a Strategy is a (Pure Strategy) Nash Equilibrium

**The** formula for if a strategy profile \(s^*\) is a Nash equilibrium is $$v_{i}(s_{i}^*,s_{-i}^*) \geq v_{i}(s_{i}',s_{-i}^*)$$ for all $$s_i' \neq s_{i}^*$$. A Nash equilibrium will always survive IESDS, but the strategies that survive IESDS are not necessarily Nash equilibria.

In Nash equilibrium, no player is made better off (i.e., they stay at the same level or worse) when they deviate.
