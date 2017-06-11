import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.math.*;




public class main {

public static void main(String[] args){

    int people = 0;
    Scanner sc;
    File filein1 = new File("Coordinates.txt");

    try{
        sc = new Scanner(filein1);
    }
    catch(FileNotFoundException nofile){
        System.out.println("File is not found");
        nofile.printStackTrace();
        return;
    }




    ArrayList<Integer> xaxis = new ArrayList<Integer>(people);
    ArrayList<Integer> yaxis = new ArrayList<Integer>(people);

    while(sc.hasNext()){
    xaxis.add(sc.nextInt());
    yaxis.add(sc.nextInt());
    }

Collections.sort(xaxis);
Collections.sort(yaxis);




    int[] xcoor = new int[2];
    int[] ycoor = new int[2];

    if(xaxis.size()/2 == 0){
        xcoor[0] = xaxis.get((xaxis.size()/2));
        xcoor[1] = xaxis.get((xaxis.size()/2)+1);


    }
    else{
    xcoor[0] = xaxis.get((xaxis.size()/2));
    xcoor[1] = -100;
    }

    if(yaxis.size()/2 == 0){
        ycoor[0] = yaxis.get((yaxis.size()/2));
        ycoor[1] = yaxis.get((yaxis.size()/2)+1);


    }
    else{
        ycoor[0] = yaxis.get((yaxis.size()/2));
        ycoor[1] = -100;
    }
int xdistance = 0;
int ydistance = 0;
int totaldistance = 0;
//A godawful attempt at counting distance between the x coordinates
for(int k =0; k <xaxis.size(); k++){
    for(int l = 0; l <xcoor.length; l++) {
        //A check made in place of not using a nonexistant coordinate
        if(xcoor[l] != -100) {
            xdistance = xdistance + (Math.abs(xcoor[l] - xaxis.get(k)));
        }
        }
    }
//Likewise, the same effect but for the y coordinates. Uses the same logic
    for(int k = 0; k <yaxis.size(); k++){
        for(int l = 0; l <ycoor.length; l++) {
            if(ycoor[l] != -100) {
                ydistance = ydistance + (Math.abs(ycoor[l] - yaxis.get(k)));
            }
            }
    }
totaldistance = xdistance + ydistance;

//This will print out the different cases of coordinates we find.
int count = 1;
for(int i = 0; i < xcoor.length; i++) {
    //Iterates through both the x and y arrays
    for(int j = 0; j < ycoor.length; j++){
        //a safety net if there is only one combination or if there is only one or two differences in length
        if(xcoor[i] != -100 || ycoor[j] != -100) {
            System.out.println("Case" + count + " (" + xcoor[i] + " " + ycoor[j] + ") " + totaldistance);
        }
        }
}
}




}