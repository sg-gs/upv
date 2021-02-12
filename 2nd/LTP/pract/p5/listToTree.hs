module ListToTree where
    data Tree a = Leaf a | Branch (Tree a) (Tree a) deriving Show

    listToTree :: [a] -> Tree a
    listToTree [x] = Leaf x
    listToTree (x:xs) = Branch (Leaf x) (listToTree xs) 