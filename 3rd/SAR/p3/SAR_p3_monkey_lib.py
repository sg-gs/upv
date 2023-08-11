#!/usr/bin/env python
#! -*- encoding: utf8 -*-
# 3.- Mono Library

import pickle
import random
import re
import sys

## Nombres: Sergio Gutiérrez Villalba

########################################################################
########################################################################
###                                                                  ###
###  Todos los métodos y funciones que se añadan deben documentarse  ###
###                                                                  ###
########################################################################
########################################################################



def sort_index(d):
    for k in d:
        l = sorted(((y, x) for x, y in d[k].items()), reverse=True)
        d[k] = (sum(x for x, _ in l), l)


class Monkey():

    def __init__(self):
        self.r1 = re.compile('[.;?!]')
        self.r2 = re.compile('\W+')


    def index_sentence(self, sentence, tri):
        words = self.r2.sub(" ", sentence.lower()).split() + ['$']
        first = '$'

        for w in words: 
            self.index['bi'][first] = self.index['bi'].get(first, {})
            self.index['bi'][first][w] = self.index['bi'][first].get(w, 0) + 1
            first = w

        pass


    def compute_index(self, filename, tri):
        self.index = {'name': filename, "bi": {}}
        if tri:
            self.index["tri"] = {}

        file = open(filename, 'r')
        sentences = file.readlines()

        for sentence in sentences:
            if sentence != "\n":
                self.index_sentence(sentence, tri)  

        sort_index(self.index['bi'])
        if tri:
            sort_index(self.index['tri'])
        

    def load_index(self, filename):
        with open(filename, "rb") as fh:
            self.index = pickle.load(fh)


    def save_index(self, filename):
        with open(filename, "wb") as fh:
            pickle.dump(self.index, fh)


    def save_info(self, filename):
        with open(filename, "w") as fh:
            print("#" * 20, file=fh)
            print("#" + "INFO".center(18) + "#", file=fh)
            print("#" * 20, file=fh)
            print("filename: '%s'\n" % self.index['name'], file=fh)
            print("#" * 20, file=fh)
            print("#" + "BIGRAMS".center(18) + "#", file=fh)
            print("#" * 20, file=fh)
            for word in sorted(self.index['bi'].keys()):
                wl = self.index['bi'][word]
                print("%s\t=>\t%d\t=>\t%s" % (word, wl[0], ' '.join(["%s:%s" % (x[1], x[0]) for x in wl[1]])), file=fh)
            if 'tri' in self.index:
                print(file=fh)
                print("#" * 20, file=fh)
                print("#" + "TRIGRAMS".center(18) + "#", file=fh)
                print("#" * 20, file=fh)
                for word in sorted(self.index['tri'].keys()):
                    wl = self.index['tri'][word]
                    print("%s\t=>\t%d\t=>\t%s" % (word, wl[0], ' '.join(["%s:%s" % (x[1], x[0]) for x in wl[1]])), file=fh)


    def generate_sentences(self, n=10):
        for _ in range(n):
            sentence = ''
            start = '$'

            for _ in range(24):
                words_dict = self.index['bi'][start][1]

                weights = []
                population = []

                for probability, word in words_dict:
                    population.append(word)
                    weights.append(probability)

                [chosen_word] = random.choices(population, weights)

                if chosen_word == '$': 
                    break

                sentence += ' ' + chosen_word if sentence != '' else chosen_word
                start = chosen_word 

            print(sentence)
        pass


if __name__ == "__main__":
    print("Este fichero es una librería, no se puede ejecutar directamente")


