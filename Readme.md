
Exception Handling in controller
JWT

Check the gitignore in initial commit
Add gitattributes
Add build.gradle and settings.gradle
Add gradlewrapper.properties

create the repo from UI, add name(jwtExample in this case)
echo "# jwtExample" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/JoyPGit/jwtExample.git
git push -u origin main


**Exception**
1 try catch
    - throw new ResponseEntity<?>
    - ensure it doesn't extend Exception, this sends the whole stacktrace in response

2 @ExceptionHandler
    - custom exception sub class supported
    - need to add getters and setters
    
    - mutliple try catch blocks for each api

3 ControllerAdvice 

