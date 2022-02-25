#!/usr/bin/env python
#! -*- encoding: utf8 -*-

# 1.- Pig Latin

import sys
import re
import os


class Translator():

    def __init__(self, punt=None):
        """
        Constructor de la clase Translator

        :param punt(opcional): una cadena con los signos de puntuación
                                que se deben respetar
        :return: el objeto de tipo Translator
        """
        if punt is None:
            punt = ".,;?!"
        self.re = re.compile(r"(\w+)([" + punt + r"]*)")

    def translate_word(self, word):
        """
        Recibe una palabra en inglés y la traduce a Pig Latin

        :param word: la palabra que se debe pasar a Pig Latin
        :return: la palabra traducida
        """
        vowels = ['a', 'e', 'i', 'o', 'u', 'y'] 
        new_word = word.lower()

        if (new_word[0].isalpha()):
            if (new_word[0] in vowels):
                new_word = word + "yay"
            else:
                first_vowel_pos = 1
                
                while (first_vowel_pos < len(new_word) and new_word[first_vowel_pos] not in vowels):
                    first_vowel_pos += 1

                new_word = new_word[first_vowel_pos:] + new_word[:first_vowel_pos].lower() + "ay"
        
        return new_word

    def translate_sentence(self, sentence):
        """
        Recibe una frase en inglés y la traduce a Pig Latin

        :param sentence: la frase que se debe pasar a Pig Latin
        :return: la frase traducida
        """
        translated_words = []

        for word, separator in self.re.findall(sentence):
            translated = self.translate_word(word)

            if (word.isupper()):
                translated = translated.upper()
            elif (word[0].isupper()):
                translated = translated[0].upper() + (translated[1:] if len(translated) > 1 else "")

            translated_words.append(translated + separator)

        return " ".join(translated_words)

    def translate_file(self, filename):
        """
        Recibe un fichero y crea otro con su tradución a Pig Latin

        :param filename: el nombre del fichero que se debe traducir
        :return: True / False 
        """
        source_file = open(filename, 'r')
        source_file_lines = source_file.readlines()
        source_file_name, source_file_ext = os.path.splitext(filename)
        
        destination_file = open(source_file_name + '_latin' + source_file_ext, 'w')

        for line in source_file_lines:
            destination_file.write(self.translate_sentence(line) + '\n')

if __name__ == "__main__":
    if len(sys.argv) > 2:
        print(f'Syntax: python {sys.argv[0]} [filename]')
        exit()
    t = Translator()
    if len(sys.argv) == 2:
        t.translate_file(sys.argv[1])
    else:
        sentence = input("ENGLISH: ")
        while len(sentence) > 0:
            print("PIG LATIN:", t.translate_sentence(sentence))
            sentence = input("ENGLISH: ")