# FileCrypt - Simple File Encryption/Decryption Tool

## Description
FileCrypt is a simple command-line tool that allows you to securely encrypt or decrypt files using a passphrase. It supports both text and binary files and provides an easy-to-use interface for basic file encryption tasks.
We will implement this using [Bouncy Castle](https://www.bouncycastle.org/documentation/documentation-java/)

Members :
- [@Bananonymous](https://github.com/Bananonymous)
- [@Syseria](https://github.com/syseria)

## Features
- Encrypt or decrypt files using a passphrase.
- Support for both text and binary files.
- Option to specify input and output files.
- Simple and intuitive command-line interface using `picocli`.

## How to use our program
#### Prerequisite
Having a file (text or binary) already created/available to encrypt.
```git
# Start by cloning it.
git clone git@github.com:Bananonymous/DAI-Labo1.git
```
```terminal
# Then build the project. (spotless:apply can be ommited)
./mvnw dependency:go-offline clean spotless:apply compile package
# Now just run it :D
java -jar ./target/FileCrypt-1.0-SNAPSHOT.jar
```
### Commands examples
We will be using a test.txt file containing `test` for our examples.
#### Encrypting
`java -jar ./target/FileCrypt-1.0-SNAPSHOT.jar <Inputfilename> <Outputfilename> ENCRYPT`
```terminal
# ENCRYPT
java -jar ./target/FileCrypt-1.0-SNAPSHOT.jar test.txt encrypted.txt ENCRYPT
```
***Expected output***<br>
Encrypting target/in.txt using Bouncycastle, output in target/out.txt <br>
Secret Key (Base64 encoded): Bnw9w2+3LOHHSpJMqtqvytv/p89KrS8uHGivq85GGcY=
```
# encrypted.txt
ruBtJtVt+tZ9u07NKL1MDQ==
```
#### Decrypting
`java -jar ./target/FileCrypt-1.0-SNAPSHOT.jar <Inputfilename> <Outputfilename> DECRYPT <secretKey>`
```terminal
# DECRYPT
java -jar ./target/FileCrypt-1.0-SNAPSHOT.jar encrypted.txt deciphered.txt DECRYPT iJjMI84eKzbXeuJHMlz3qvQm4jZr312yU1rPMvcDkh8=
```
***Expected output***<br>
Decrypting target/out.txt with key Bnw9w2+3LOHHSpJMqtqvytv/p89KrS8uHGivq85GGcY= using Bouncycastle, output in target/deciphered.txt
```
# deciphered.txt
test
```

## V2.0 ideas
1. Letting the user choose which encryption format they want to use from the availabe `symmetric key algorithms` Bouncycastle offers. (ie. AES, ARIA, Ascon)
2. Letting the user provide the passphrase to be used.
3. Letting the user encrypt or decrypt multiple files before terminating the program.<br>
   while loop for as long as a letter - q - or a the specific QUIT command is entered.

[Repo](https://github.com/Bananonymous/DAI-Labo1)
