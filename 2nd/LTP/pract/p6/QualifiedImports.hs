module QualifiedImports where

import qualified Circle
import qualified Triangle

main = do
  putStrLn ("Triangle area is " ++ show (Triangle.area 2 5))
  putStrLn ("Circle area is " ++ show (Circle.area 5))