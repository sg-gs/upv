module DoubleAll where
    doubleAll :: [Int] -> [Int]
    doubleAll [] = []
    doubleAll list = map(*2) list