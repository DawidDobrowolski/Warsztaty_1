# Popular words
This application searches words in article headers on a selected website and save their list in .txt file.

## Description
Words are taken from the page headers (span elements title) with jsoup library. In the next step array with words is sorted ascending and file with words is created (popular_words.txt). 

In application we have an array with words which should be excluded. Words from previous file are loaded and filtered. Finally new file is created (filtered_popular_words.txt). 