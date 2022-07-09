package com.company.arrays;

/**
 * Problem statement:
 * Suppose you are working on Google Photos. you are wring the client application. Request comes to you to upload N photos. you fire the request to server to upload those N photos to server. Then the server responds back with acknowledgements that a particular photo is uploaded.
 * Example. Suppose you are uploading 10 Photos, The server can respond back in any order, such as 1,2,4,5,3,7,6,10,9,8 . Now at any given point of time we need to check what is the maximum photo number which has been uploaded continously.
 * Example.
 *
 * ack(1),
 * getMax()-> returns 1, because the maximum photo uploaded is 1
 * ack(2),
 * getMax()-> returns 2, because the maximum photo uploaded is 2
 * ack(4)
 * getMax()-> returns 2 only because 3 has not been recieved yet
 * ack(5)
 * getMax()-> returns 2 again because 3 has not been recieved yet
 * ack(3)
 * getMax()-> returns 5 because we recieved 3 and 4 and 5 also we recieved eralier. using this example you have to complete the following class
 */

public class Google_PhotosClientOrderedStream {
    private class PhotosClient {
        private int max = 0, n;
        private boolean[] ack;
        // initializer
        public PhotosClient(int n) {
            this.n = n;
            ack = new boolean[n+1];
        }
        // this method is called each time you receive acknowledgement from the server
        public void ack(int x) {
            ack[x] = true;
            if(max+1 == x){
                max = x; // we have received continuous ack till X
                while(max+1 < ack.length && ack[max+1]){
                    max++;
                }
            }
        }
        // this method will be called in between to check what the maximum photo number has been uploaded successfully
        public int getMax() {
            return max;
        }
    }

    public void setup(){
        PhotosClient client = new PhotosClient(10);
        int[] a = new int[]{1,2,4,5,3,7,6,10,9,8};
        for(int b : a){
            client.ack(b);
            System.out.print(client.getMax());
        }
    }
}
