module Remainder where
    remainder :: Int -> Int -> Int
    remainder q1 q2 
        | (q1 - q2) > 0 && (q1 - q2) >= q2 = remainder (q1-q2) q2
        | (q1 - q2) >= 0 = q1 - q2
        | otherwise = q2