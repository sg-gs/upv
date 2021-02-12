module Divisors where
    divisors :: Int -> [Int]
    divisors x = [y | y <- [1..x], x `mod` y == 0];
      