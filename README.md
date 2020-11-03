# A web site for dislaying any mixture of more THAN 100 different Bible translations #

## Usage ##

index.html has a set of radio buttons which specifies which
translation language comes first and aset of check boxes which select
additional translations.  The reference box accepts a Bible reference
like Ge. 1:1-10 which tells what passage to display for the selected
language(s).

## Database Tables ##

The database has 1 name table which lists book names in English.  It is used to translate book numbers such as 1 to Genesis.  

It has text tables named text0, text1, ..., text22  which store verses of the Bible as indexed by 3-letter book code or book number, chapter number, and verse number.  The column names for verse text match the file names from the corpus with special characters translated to underscores.

## Utility Programs ##

The system for preparing the database has the following programs:

### ReadAnyXmlFile ###

This program is intended for exploring an XML file.  It reads a file and  prints out the name and text content for each element in the document along with the names and values of all attributes.

### JavaXlmParseMain ###

This program reads a corpus file and prints the text content and attributes of all the SEG elements.  It is a more specific version of the program that reads any XML file.

### BuildColumnsAndRadiosMain ###

Reads all of the corpus file names and creates alter table add column statements to add a column for each Bible to the appropriate table.

It also generates a set of radio buttons so that each translation can be selected as the first in a table of verses and a set of checkboxes so that each translation can be selected for inclusion in a multi-translation table.

### LoadCorpusBibleFilesMain ###

Generates an update statement for each verse in the corpus.  The statements set the value of the appropriate column of the appropriate table based on 3-letter book code, chapter number, and verse number.

Inserts are split into different files. Each file has inserts for each table which holds 5 Bibles.

The program also writes an error file for each Bible file that specifies verses that do not exist.  For example,
the Piate Bible supplies a text string for verse **3JO.1.15** but 3rd John doesn't have verse 15, it ends with verse 14.