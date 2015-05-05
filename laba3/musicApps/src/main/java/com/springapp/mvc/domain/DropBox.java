package com.springapp.mvc.domain;

import com.dropbox.core.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Scanner;

public class DropBox {
    public static void Auth() throws URISyntaxException, IOException, DbxException {
        DbxAppInfo appInfo =new DbxAppInfo("b1jie0n0bval1mo","cackb3zbqfas8nn");
        DbxRequestConfig config =new DbxRequestConfig("music", Locale.getDefault().toString());
        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config,appInfo);
        Desktop.getDesktop().browse(new URI(webAuth.start()));
        System.out.println("Enter govno");
        Scanner scanner=new Scanner(System.in);
        String code=scanner.next();
        System.out.println();
        System.out.println(webAuth.finish(code).accessToken);
        scanner.close();
    }
    public static String UpLoad(String path) throws IOException, DbxException {
        DbxRequestConfig config = new DbxRequestConfig("music",Locale.getDefault().toString());
        DbxClient client = new DbxClient(config,"UiNw-gJDUVAAAAAAAAAAK3KEdGJYKq3tL3j7G7m3nD1_D2k2Xb1HUujZZJ3CYoTJ");
        String full="D:\\Музыка\\"+path;
        File file=new File(full);
        FileInputStream fileInputStream = new FileInputStream(file);
        client.uploadFile("/"+path, DbxWriteMode.add(), file.length(), fileInputStream);
        fileInputStream.close();
        return client.createTemporaryDirectUrl("/"+path).url;
    }
}
