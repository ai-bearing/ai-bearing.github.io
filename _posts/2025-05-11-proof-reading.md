---
layout: post
use_math: true
title: "How to read a proof"
permalink: "/posts/reading_a_proof.html"
---
The progression of math seems simple enough. We start with algebra in middle school, geometry and trigonometry in the early part of high school, calculus in latter part of high school or in the first year of college, and then around our second year of undergrad, we learn linear algebra or the mysterious "discrete math," where we have to read and understand proofs. Worse, they suddenly become the bulk of the math we learn. Every day becomes a morass of definitions, theorems, and proofs, and then we get tripped up. Instead of drilling calculations and understanding identification strategies for e.g. integrals or derivatives, we're thrust into a world of logic, reading, and writing. It's easy to get irked. After all, the mathematics curriculum up until this point has not prepared students well for the task.

Yet, at the same time, proofs are essential. They are what separates mathematics from, effectively, spell-casting. Math moves away from rote rules that seem pulled out of thin air into rigorous, formal, logical progressions that can be followed all the way back to certain, set,[^1] axioms that we have collectively decided are true.

So, proofs are important. Having accepted this as fact, we quickly run into another problem: how does one read a proof exactly? What are the steps one must take to comprehend the proof's central idea?

Here, I will give an outline of how I read proofs.[^2] 

### Step 1: Read the Theorem/Proposition/Corollary/Lemma
This seems obvious enough. Yet, at the same time, this is often the hardest step. When I say "read," I mean truly, deeply understand every word, symbol, and definition brought up in the statement. What are the implications? Is the statement a one-directional implication, or a biconditional? What are the background assumptions and conditions that the theorem accepts in order to be properly applied? Are there any implicit conditions?

Statements of theorems or propositions will often reference previous definitions, equations, or theorems, akin to the form "Theorem 2.3" or similar. If not the number of the theorem, make sure that as you go back and read the referenced theorem, you understand said result fully (if not the proof itself).

Knowing what the theorem says, its context, conditions, and applications is often more than half the battle. Profound results such as the [Bolzano–Weierstrass theorem](https://en.wikipedia.org/wiki/Bolzano–Weierstrass_theorem) from analysis or the [Rank–Nullity theorem](https://en.wikipedia.org/wiki/Rank–nullity_theorem) from linear algebra are useful in and of themselves separated from their proofs, and many other theorems and proofs rely on building the necessary conditions to apply those results.

### Step 2: Overview
I've often heard fellow students complain about not being able to keep straight all the various proof techniques. The main methods of proof are [direct proof](https://en.wikipedia.org/wiki/Direct_proof), [proof by contradiction](https://en.wikipedia.org/wiki/Proof_by_contradiction), [proof by contrapositive](https://en.wikipedia.org/wiki/Contraposition), and [induction](https://en.wikipedia.org/wiki/Mathematical_induction). While these proof techniques, and the other logical rules such as [De Morgan's Laws](https://en.wikipedia.org/wiki/De_Morgan%27s_laws) and rules surrounding [existential and universal quantifiers](https://en.wikipedia.org/wiki/Quantifier_(logic)), may seem annoying and trite,[^3] they are the bread and butter of any proof. Make sure you know these well.[^4]

Before even writing a single word in your notebook, make sure you know exactly what techniques the author is planning on using for their proof. Authors will often not specify at the outset what method they are using, and expect the reader to pick up instantly.

Is there a reference to an induction hypothesis? If so, what is the base case, and are they using [strong induction](https://discrete.openmathbooks.org/dmoi4/sec_seq-strong-induction.html) or weak induction? Does the author assume the opposite of the hypothesis and plan to find a contradiction, or are they assuming the negation of the conclusion and exhibiting the negation of the hypothesis? Or, is the author just roughing it and doing the (sometimes necessary) brute-force computations.

Proofs will often use a blend of these techniques to maximize their effectiveness. A proof may use contradiction to prove the induction hypothesis, which allows the author to prove via the contrapositive. Proofs are often complex, and time spent at the beginning understanding the author's method of proof can often save many hours of confusion on the back end.

At this point, feel free to mark your page, close the book, and attempt to complete the proof yourself. This is an optional step, but occasionally useful to try to develop confidence in your proof-writing and proof-understanding abilities. Maybe you succeed and use a more efficient way than the textbook author, or maybe you forget an important part of the argument. Either way, it is better to attempt and fail than to never attempt at all.

### Step 3: Line by Line
Now comes the fun part: writing down the proof. Follow it, and copy some of it, yes, but do not hesitate to write notes to yourself, mark up the textbook with annotations and highlights, and generally make the proof your own. You can even make little [drolleries](https://en.wikipedia.org/wiki/Drollery) if you're so inclined.

As you take notes, understand what structures and ideas the author introduces and the purpose of such introductions. This is where annotations can help; some textbook writers are often terse with their proofs (writing is annoying, after all), and will often use difficult-to-follow, slick methods for the proof. I've certainly dealt with my fair share of "huh?"s and "where did that come from?"s while reading through various textbook proofs. It's okay to slow things down and let ideas simmer.

Once you finish going through the proof and taking notes, take a breath. Read through it once more in order to verify that you understand what the theorem is proving, the proof method, and the finer details that the proof uses. If there are any points of confusion or doubt, go back and visit the proof, or try to find other proofs of the same statement.[^5] There is no shame in using various other resources to understand something.

### Step 4: Revisit
Sometimes you see a proof once and you're able to completely remake it from scratch. Other times, it takes a lot more effort, and even with proofs that you've seen constantly, you can only remember the barebones. Regardless, keep revisiting old theorems and proofs in order to keep them fresh. Math is not a sprint, but an ultramarathon; you will learn the same topic from different angles many different times throughout your education, and it is not only okay, but completely expected.

There's a lot of psychological research (of questionable quality) about the effectiveness of spaced repetition methods in improving memory. Regardless of if you want to use a system like [Anki](https://apps.ankiweb.net) or my preferred technique (just looking at it when you feel you've forgotten it), it is important to avoid the temptation to look at a proof, study it once, and move on.

### An Example
We will consider a simple theorem from [ProofWiki](https://proofwiki.org/wiki/Surjection_iff_Right_Inverse). This is the kind of example that one might encounter in their discrete math class.
> A function $f\colon S\rightarrow T$ is a surjection if and only if there is a function $g\colon T\rightarrow S$ such that $f\circ g = \operatorname{id}_{T}$.

Reading through the theorem, we note two things. First, we recall that a surjection is a function that maps fully onto its codomain. Second, it is a biconditional, so we must prove both directions. Generally speaking, there are two ways to attack a biconditional:
- prove both directions directly (i.e., assume A, show B, then assume B and show A), or
- prove one direction directly, then prove the opposite direction (i.e., assume A, show B, then assume Not A and show Not B).

Quickly scanning the proof, we see that it is quite short, and that it uses the first method.

Examining the proof of the theorem, we see that in the forward direction, it uses a previous result. Namely, since the identity map is a surjection, and $f\circ g = \operatorname{id}_{T}$, we use the fact that the composition of two functions is a surjection implies that the outermost function is a surjection.

In the reverse direction, we are required to consider a particular family of subsets, $\{f^{-1}(y)\}_{y\in T}$, where $f^{-1}(y)$ is the [preimage](https://proofwiki.org/wiki/Definition:Preimage/Mapping/Element) of the element $y$. Note that the preimage (or inverse image) of an element is *not* the same as "the" inverse of the element. However, since $f$ is a surjection, we know that $f^{-1}(y)$ is not empty for all $y\in T$. We must use the [axiom of choice](https://en.wikipedia.org/wiki/Axiom_of_choice) to allow us a map $g\colon T\rightarrow S$ such that $g(y)\in \\{f^{-1}(y)\\}_{y\in Y}$ for all $y\in T$.[^6]

### Final Thoughts

Reading a proof (and understanding a proof) is not easy. However, as math students, we are not being trained simply in the art of calculation, but in the art of logical reasoning and problem-solving. Math isn't really math without proofs, and so it is that much more important to actually understand in detail how to read them. However, this blog post is not a suitable substitute for actually reading the proofs (and doing the exercises) themselves. At the same time, remember that math is a journey (not a destination). Take your time, understand the material, and don't hesitate to re-fill holes in your knowledge as you start to grow into the field.

[^1]: Well, "set" is a strong word, but for the most part people generally accept a core of axioms known as the [Zermelo–Fraenkel](https://en.wikipedia.org/wiki/Zermelo–Fraenkel_set_theory) axioms for set theory that enable a variety of fundamental proofs and constructions that are, in the words of [Eugene Wigner](https://en.wikipedia.org/wiki/The_Unreasonable_Effectiveness_of_Mathematics_in_the_Natural_Sciences), unreasonably effective in the natural sciences.
[^2]:These techniques are not universal; just as there are always variations in a work of origami (and even in the same work of origami made by the same person), there will always be variations in how one attacks a proof in front of them. It is always up to the reader to make the metaphorical model themselves.
[^3]: Some fixtures, like truth tables, are actually annoying and trite.
[^4]: One of my professors likes to say that you should be able to recite them "at 3 a.m." This may be a little difficult if you've never seen these ideas before, but I promise that you'll pick up on them relatively quickly, and they'll be 3 a.m. material soon enough.
[^5]:[Math StackExchange](https://math.stackexchange.com) is your friend, here.
[^6]: Fun fact: it turns out that the statement "every subjective function has a left inverse" is logically equivalent to the axiom of choice.
