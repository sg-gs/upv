module Symmetric where
    data Tree a = Leaf a | Branch (Tree a) (Tree a) deriving Show
    
    symmetric :: Tree a -> Tree a
    symmetric (Leaf a) = Leaf a
    symmetric (Branch x y) = Branch (symmetric y) (symmetric x) 