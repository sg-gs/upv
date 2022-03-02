#! -*- encoding: utf8 -*-

## Nombres: 

########################################################################
########################################################################
###                                                                  ###
###  Todos los métodos y funciones que se añadan deben documentarse  ###
###                                                                  ###
########################################################################
########################################################################

import argparse
import re
import os
from functools import reduce


def sort_dic_by_values(d, asc=True):
    return sorted(d.items(), key=lambda a: (-a[1], a[0]))

class WordCounter:

    def __init__(self):
        """
           Constructor de la clase WordCounter
        """
        self.clean_re = re.compile('(\W+)([,,.?!]*)')

    def write_stats(self, filename, stats, use_stopwords, full):
        """
        Este método escribe en fichero las estadísticas de un texto
            
        :param 
            filename: el nombre del fichero destino.
            stats: las estadísticas del texto.
            use_stopwords: booleano, si se han utilizado stopwords
            full: boolean, si se deben mostrar las stats completas

        :return: None
        """
        symbols_dict = stats['symbol']
        words_dict = stats['word']

        biwords_dict = stats['biword']
        bisymbols_dict = stats['bisymbol']

        sort_by_alpha = lambda t: t[0]
        sort_by_freq = lambda w: (w[1], w[0])

        words_by_alpha = sorted(words_dict.items(), key=sort_by_alpha)
        words_by_freq = sorted(words_dict.items(), key=sort_by_freq, reverse=True)

        symbols_by_alpha = sorted(symbols_dict.items(), key=sort_by_alpha)
        symbols_by_freq = sorted(symbols_dict.items(), key=sort_by_freq, reverse=True)

        biwords_by_alpha = sorted(biwords_dict.items(), key=sort_by_alpha)
        biwords_by_freq = sorted(biwords_dict.items(), key=sort_by_freq, reverse=True)

        bisymbols_by_alpha = sorted(bisymbols_dict.items(), key=sort_by_alpha)
        bisymbols_by_freq = sorted(bisymbols_dict.items(), key=sort_by_freq, reverse=True)

        lines = []
        lines.append('Lines: ' + str(stats['nlines']) + '\n')
        lines.append('Number words (including stopwords): ' + str(stats['nwords'] + stats['nstopwords']) + '\n')
        lines.append('Number words (without stopwords): ' + str(stats['nwords']) + '\n')
        lines.append('Vocabulary size: ' + str(len(words_dict.items())) + '\n')

        lines.append('Number of symbols: ' + str(reduce(lambda a, b: a + b[1], symbols_dict.items(), 0)) + '\n')
        lines.append('Number of different symbols: ' + str(len(stats['symbol'].items())) + '\n') 
        
        lines.append('Words (alphabetical order): \n')
        for word in words_by_alpha:
            lines.append('\t{0}: {1}\n'.format(word[0], str(word[1])))

        lines.append('Words (by frequency): \n')
        for word in words_by_freq:
            lines.append('\t{0}: {1}\n'.format(word[0], str(word[1])))

        lines.append('Symbols (alphabetical order): \n')
        for symbol in symbols_by_alpha:
            lines.append('\t{0}: {1}\n'.format(symbol[0], str(symbol[1])))

        lines.append('Symbols (by frequency): \n')
        for symbol in symbols_by_freq:
            lines.append('\t{0}: {1}\n'.format(symbol[0], str(symbol[1])))

        lines.append('Word pairs (alphabetical order): \n')
        for biword in biwords_by_alpha:
            lines.append('\t{0}: {1}\n'.format(biword[0], str(biword[1])))

        lines.append('Word pairs (by frequency): \n')
        for biword in biwords_by_freq:
            lines.append('\t{0}: {1}\n'.format(biword[0], str(biword[1])))
        
        lines.append('Symbol pairs (alphabetical order): \n')
        for bisymbol in bisymbols_by_alpha:
            lines.append('\t{0}: {1}\n'.format(bisymbol[0], str(bisymbol[1])))

        lines.append('Symbol pairs (by frequency): \n')
        for bisymbol in bisymbols_by_freq:
            lines.append('\t{0}: {1}\n'.format(bisymbol[0], str(bisymbol[1])))

        with open(filename, 'w') as fh:
            for line in lines: 
                fh.write(line)

        if full is True: 
            for line in lines:
                print(line)

    def file_stats(self, filename, lower, stopwordsfile, bigrams, full):
        """
        Este método calcula las estadísticas de un fichero de texto

        :param 
            filename: el nombre del fichero.
            lower: booleano, se debe pasar todo a minúsculas?
            stopwordsfile: nombre del fichero con las stopwords o None si no se aplican
            bigram: booleano, se deben calcular bigramas?
            full: booleano, se deben montrar la estadísticas completas?

        :return: None
        """
        stopwords = [] if stopwordsfile is None else open(stopwordsfile).read().split()

        # variables for results

        # TODO:
        # - Biwords count is not correct
        # - Sort by frequency and alphabetically (this last step seems not to work)

        sts = {
                'nwords': 0,
                'nlines': 0,
                'word': {},
                'symbol': {},
                'nstopwords': 0
                }

        if bigrams:
            sts['biword'] = {}
            sts['bisymbol'] = {}

        file = open(filename, 'r')
        lines = file.readlines()

        for line in lines:
            words = list(map(lambda w: re.sub(self.clean_re, "", w.lower() if lower else w), line.split()))
            words = ['$'] + words + ['$']
            sts['nlines'] += 1

            if bigrams:
                n = len(words)

                for i in range(n - 1):
                    if (words[i] == '$' and i == n - 1) or words[i] in stopwords or words[i+1] in stopwords: 
                        continue

                    bigram = words[i] + ' ' + words[i+1]
                    sts['biword'][bigram] = sts['biword'].get(bigram, 0) + 1

                    bn = len(bigram)
                    for j in range(bn - 1):
                        # not in ' $'?
                        if bigram[j] == '$' or bigram[j] == ' ' or (j + 1 < bn and bigram[j+1] == ' '):
                            continue

                        bisymbol = bigram[j] + bigram[j+1]
                        sts['bisymbol'][bisymbol] = sts['bisymbol'].get(bisymbol, 0) + 1
            
            words = map(lambda x: re.sub(self.clean_re, "", x.lower() if lower else x), line.split())
            
            for word in words:
                if word in stopwords:
                    sts['nstopwords'] += 1
                else:
                    sts['nwords'] += 1
                    sts['word'][word] = sts['word'].get(word, 0) + 1

                    for symbol in word:
                        sts['symbol'][symbol] = sts['symbol'].get(symbol, 0) + 1

        source_file_name, source_file_ext = os.path.splitext(filename)
        new_filename = source_file_name + '_'

        if lower is True:
            new_filename += 'l'

        if stopwordsfile is not None:
            new_filename += 's'

        if bigrams is True:
            new_filename += 'b'

        if full is True:
            new_filename += 'f'

        print(sts)

        new_filename += '_stats' + source_file_ext

        self.write_stats(new_filename, sts, stopwordsfile is not None, full)

    def compute_files(self, filenames, **args):
        """
        Este método calcula las estadísticas de una lista de ficheros de texto

        :param 
            filenames: lista con los nombre de los ficheros.
            args: argumentos que se pasan a "file_stats".

        :return: None
        """

        for filename in filenames:
            self.file_stats(filename, **args)

if __name__ == "__main__":

    parser = argparse.ArgumentParser(description='Compute some statistics from text files.')
    parser.add_argument('file', metavar='file', type=str, nargs='+',
                        help='text file.')

    parser.add_argument('-l', '--lower', dest='lower',
                        action='store_true', default=False, 
                        help='lowercase all words before computing stats.')

    parser.add_argument('-s', '--stop', dest='stopwords', action='store',
                        help='filename with the stopwords.')

    parser.add_argument('-b', '--bigram', dest='bigram',
                        action='store_true', default=False, 
                        help='compute bigram stats.')

    parser.add_argument('-f', '--full', dest='full',
                        action='store_true', default=False, 
                        help='show full stats.')

    args = parser.parse_args()
    wc = WordCounter()
    wc.compute_files(args.file,
                     lower=args.lower,
                     stopwordsfile=args.stopwords,
                     bigrams=args.bigram,
                     full=args.full)
