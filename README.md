
Target:

We ask you to create an application that verifies the correctness of a sequence of moves in the "game of
change ”: given a sequence of alphabetic strings, verify that each element of the sequence is a word
of complete sense and that every word except the first is obtained from the previous one by substitution,
adding or removing only one letter at a time. For example, the sequence:
1: TORRE
2: TORVE
3: TORVO
4: CORVO
5: COVO
6: ROVO
7: ROGO
8: ROSO
9: POSO
10: POSTO
is correct because all words are obtained from the previous one by replacing a letter, except COVO which
is obtained from CORVO by removing a letter and POSTO which is obtained from POSO by adding a letter. To the
reverse the sequence:
1:LAGO
2:MAGO
3:MAGA
4:MAGLIA
5:TAGLIA
6:RAGLIA
7:RAGGI
8:PAGGI
is incorrect because two letters were added in the transition from MAGA to MAGLIA and in the transition from RAGLIA to
RAYS one letter was removed and another changed at the same time. 


Input format:

The program takes two text files as input (use command line arguments). The first
file contains the game's move sequence, one move per line with the following syntax:
			<number>: <word>
where the various elements are specified as follows:
• <number> is the sequential number of the move, starting from 1.
• <word> is an alphabetic string of unaccented uppercase only letters.

The second file contains a list of legal words to use in the game. The file is divided into several lines, one
word by line. Words are written in lowercase letters and have no accented letters. The program
it does not take any other type of input other than the one specified, in the manner indicated and that it can
assume syntactically correct.


Output format:

The program must print the answer on the screen:
CORRECT
if the move sequence is correct, or
ERROR: line <n1>
ERROR: line <n2>
...
where <n1> is the first line where an error was found, <n2> is the second line where an error was found
and so on. All errors in the first input file must be reported. The mistake can be
due both to the absence of the string from the word list provided in the second input file, and to the use of
an illegal move. The program does not issue any other type of output than the one specified.


