module NumCbetw2 where
    import Data.Char

    numCbetw2 :: Char -> Char -> Int
    numCbetw2 c1 c2 = abs(ord c2 - ord c1):