module AddRange where
    addRange :: Int -> Int -> Int
    addRange x y 
        | x == y = x
        | x < y = x + addRange(x+1) y
        | otherwise = addRange y x