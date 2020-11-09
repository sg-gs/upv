module Leapyear where
    leapyear :: Int -> Bool
    leapyear x 
        | (x `mod` 4 == 0) && (x `mod` 100 /= 0) = True
        | otherwise = False