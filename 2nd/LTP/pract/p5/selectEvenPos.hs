module SelectEvenPos where
    selectEvenPos :: [Int] -> [Int]
    selectEvenPos [] = []
    selectEvenPos l = [(l !! y) | y <- [0..(length l)], y `mod` 2 == 0]