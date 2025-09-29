---
layout: post
use_math: true
title: "PIDs, UFDs, and All That"
permalink: "/posts/integral_domains.html"
---

In algebra, one of the central structures is that of the [ring](https://en.wikipedia.org/wiki/Ring_(mathematics)) — specifically here, we focus on unital, commutative rings (i.e., those with commutative multiplication and a multiplicative identity) that admit no zero-divisors. These are known as integral domains, and there are a few major ones that we will focus on.

## Euclidean Domains
From grade school, we know that we can divide two integers together with remainder — i.e., if $a,b\in \mathbb{Z}$, then there are unique $q$ and $r$ such that $ a = qb + r,$ where $r = 0$ or $|r| < b$. Then, in high school, we learn that if we have two polynomials (with real coefficients), $a(x)$ and $b(x)$, then we may divide $a(x)$ by $b(x)$ to find an expression of the form $a(x) = q(x)b(x) + r(x)$, where $r(x) = 0$ or $\deg(r) < \deg(b)$.

These are the two archetypal examples of a Euclidean domain, which admits a much more formal definition as follows.
> We say $R$ is a Euclidean domain if $R$ admits a norm $N\colon R\setminus \{0\}\rightarrow \mathbb{N}$ such that any two elements $a,b\in R\setminus \{0\}$ admit division with remainder. That is, we may write $a = qb + r$, where $r = 0$ or $N(r) < N(b)$.

Division with remainder is a very powerful tool, and we will see soon enough that this allows Euclidean domains to admit many nice properties. One of those is that Euclidean domains are _Principal Ideal Domains_, which we discuss next.
