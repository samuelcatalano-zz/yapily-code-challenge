# Yapily Code Challenge
Technical Code of Yapily:

### First steps:
- From an IDE or a text editor, open the **application.properties** file and replace the secrets by the secrets of the *yapily-secrets* file.
- Link to download the secrets file: https://storage.googleapis.com/yapily-code-challenge/yapily-secrets

### How to compile application:
> `mvn clean install`

### How to run the application:
> IDE (IntelliJ, Eclipse, NetBeans):
- Importing the project as Maven project on your favourite IDE.
- Build project using Java 8
- Run/Debug project from Main Application Class :: YapilyCodeChallengeApplication

> Terminal:
- `mvn spring-boot:run`

### Acessing Swagger | Open API:
Once with the application running:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

![enter image description here](https://i.imgur.com/hZEH9kt.png)

### APIs:
> First step :: The authentication process:

You need to use a tool for testing RESTful services (Web APIs) by sending HTTP requirements and analyzing their feedback like Postman or AdvanceRestClient. In this example I use the Postman.

On the Postman, select the option POST and put the path as [localhost:8080/oauth/token](localhost:8080/oauth/token)

On the tab *Authorization*, select the type *Basic Auth* and put the **Username** and **Password** that you got on the _yapily-secrets_ file.

On the tab *Body*, put the keys and values as exactly are in the image once again replacing the **username** and **password** by the values that you got on the the _yapily-secrets_ file.

![enter image description here](https://i.imgur.com/VQtyFtS.png)
![](https://i.imgur.com/4oNqXdr.png)

After doing that, send the *POST* and get the key called ***access_token***. This key expires after a while and you need to send another *POST* to get a new valid key.

***GET*** http://localhost:8080/status

On the Postman, select the option *GET* and put the path like above, go the tab *Authentication* select the type *Bearer Token* at this time and put the ***acess_token*** that you got at the last step into the field on right and click *Preview Request*. After that you're authorized and is able to send the request.

![enter image description here](https://i.imgur.com/wbMMvKK.png)

***GET*** http://localhost:8080/facts

On the Postman, select the option *GET* and put the path like above, go the tab *Authentication* select the type *Bearer Token* at this time and put the ***access_token*** that you got at the last step into the field on right and click *Preview Request*. After that you're authorized and is able to send the request.

![enter image description here](https://i.imgur.com/PUixOAh.png)

***GET*** http://localhost:8080/facts/{factId}

On the Postman, select the option *GET* and put the path like above, go the tab *Authentication* select the type *Bearer Token* at this time and put the ***access_token*** that you got at the last step into the field on right and click *Preview Request*. After that you're authorized and is able to send the request.

![enter image description here](https://i.imgur.com/fShZwbG.png)

***GET*** http://localhost:8080/facts/{factId}?lang={languageCode}

On the Postman, select the option *GET* and put the path like above, go the tab *Authentication* select the type *Bearer Token* at this time and put the ***access_token*** that you got at the last step into the field on right and click *Preview Request*. After that you're authorized and is able to send the request. The parameter *lang* is not required. If you don't pass the parameter, the response will return only the fact by the chose id. If you pass the lang parameter, then the will return the fact by id with the text translated using the *Yandex Translate API* to the target language chose.

![enter image description here](https://i.imgur.com/fA2zz07.png)

## Yandex languages and characters support:

-   Azerbaijani (az)
-   Albanian (sq)
-   English (en)
-   Arabic (ar)
-   Armenian (hy)
-   Bashkir (ba)
-   Belarusian (be)
-   Bulgarian (bg)
-   Hungarian (hu)
-   Greek (el)
-   Georgian (ka)
-   Danish (da)
-   Hebrew (he)
-   Spanish (es)
-   Italian (it)
-   Kazakh (kk)
-   Catalan (ca)
-   Latvian (lv)    
-   Lithuanian (lt)
-   Macedonian (mk)
-   German (de)
-   Dutch (nl)
-   Norwegian (no)
-   Persian (fa)
-   Polish (pl)
-   Portuguese (pt)
-   Romanian (ro)
-   Russian (ru)
-   Serbian (sr)
-   Slovak (sk)
-   Slovenian (sl)
-   Tatar (tt)
-   Turkish (tr)
-   Ukrainian (uk)
-   Finnish (fi)
-   French (fr)
-   Croatian (hr)
-   Czech (cs)
-   Swedish (sv)
-   Estonian (et)
