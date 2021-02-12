module Primes where
    import Divisors ( divisors )
    isPrime :: Int -> Bool
    isPrime x = length (divisors x) <= 2 
    primes :: Int -> [Int]
    primes x = take x [y | y <- [1..], isPrime y]