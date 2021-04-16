# Simple Calculator and Currency Converter 
## Desquared Project | April 2021

The purpose of the project is to create a simple (not scientific) calculator application and to add the ability to convert an amount between different currencies using a public API. I implemented the app using [Android Studio](https://developer.android.com/studio) and public API [fixer.io](http://fixer.io/).

The application starts with an activity called StartActivity. The user can choose if he wants to use the Calculator or the Converter:

![StartActivity](/screenshots/start.png?raw=true)


## MainActivity - Calculator:
The user can perform simple mathematical operations (addition +, substraction -, multiplication x, division ÷), make a number positive/negative (+/-) or find the percentage of it (%). C button clears the input and DELETE button deletes the last character of the input. By clicking the back button, he will return to the StartActivity.

![MainActivity](/screenshots/calculator.png?raw=true)


## ConvertActivity - Converter:
The user can convert an amount between many different currencies and the result is rounded to 3 decimals. He can also change the values between the FROM and TO fields. By clicking the back button, he will return to the StartActivity.

![ConvertActivity](/screenshots/converter.png?raw=true)

Amount: 8  
FROM (Base Currency Code): CHF  
TO (Target Currency Code): QAR  
Date of screenshot: 16 / 4 / 2021
