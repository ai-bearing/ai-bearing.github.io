---
title: "Stats Note Sheet"
format: 
  html:
    keep-md: true
---



## Graphing Normal and T Distributions




Normal Distribution:

::: {.cell}

```{.r .cell-code}
normdist <- ggplot(data.frame(x = c(-4, 4)), aes(x = x)) +
        stat_function(fun = dnorm)
normdist
```

::: {.cell-output-display}
![](graphing_sheet_files/figure-html/unnamed-chunk-2-1.png){width=672}
:::
:::

$T$ Distribution:

::: {.cell}

```{.r .cell-code}
tdist <- ggplot(data.frame(x = c(-4, 4)), aes(x = x)) +
        stat_function(fun = dt, args = list(df = 5))
tdist
```

::: {.cell-output-display}
![](graphing_sheet_files/figure-html/unnamed-chunk-3-1.png){width=672}
:::
:::


Plotting $T$ and Normal Distribution:

::: {.cell}

```{.r .cell-code}
bothdist <- ggplot(data.frame(x=c(-4,4)),aes(x=x)) + 
  stat_function(fun=dnorm,color="red") + 
  stat_function(fun=dt,args=list(df=5),color="blue")
bothdist
```

::: {.cell-output-display}
![](graphing_sheet_files/figure-html/unnamed-chunk-4-1.png){width=672}
:::

```{.r .cell-code}
#Standard Normal distribution in red, T distribution in blue
```
:::