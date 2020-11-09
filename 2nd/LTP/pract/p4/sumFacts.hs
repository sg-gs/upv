module SumFacts where

    fact :: Int -> Int
    fact 0 = 1
    fact n = n * fact (n-1)

    sumFacts :: Int -> Int
    sumFacts x 
        | x == 0 = 0
        | otherwise = fact x + sumFacts (x-1) 