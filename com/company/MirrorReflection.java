package com.company;

/**
 * 858. Mirror Reflection
 * Medium
 *
 * There is a special square room with mirrors on each of the four walls. Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
 *
 * The square room has walls of length p and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.
 *
 * Given the two integers p and q, return the number of the receptor that the ray meets first.
 *
 * The test cases are guaranteed so that the ray will meet a receptor eventually.
 *
 *
 *
 * Example 1:
 *
 * Input: p = 2, q = 1
 * Output: 2
 * Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
 *
 * Example 2:
 *
 * Input: p = 3, q = 1
 * Output: 1
 */


/**
 * https://leetcode.com/problems/mirror-reflection/discuss/2379986/Detailed-Explanation-and-Illustration-with-simple-python-solution%3A-Beats-100
 *
 * The idea of this question is not as complicated as people think:
 *
 *     Let us assume that it takes 'n' number of iterations for a ray to meet a receptor ('n' will be finite according to the question's description).
 *     Each time the ray hits a mirrors, it travels a certain amount of constant 'vectical/horizontal' distance. That distance is constant in each iteration - and it's simply 'q' as laws of reflection follows perfect symmetry.
 *
 * For instance, let us assume the ray reflected twice - on each iteration (reflection) it travels a distance of q. Since this contant distance can be either vertical or horizontal depending on which wall the mirror reflects, it could be difficult to visualize. Thus, we can imagine that we have multiple vertical rooms on top of one another - this will help in visualization as now the ray only travels vertically:
 * image
 *
 * Thus, the total vertical distance travelled after every iteration can be computed as n*q.
 *
 *     We know that the receptors are 'p' distance apart the corners of a square. Thus, in any iteration, if the total distance travelled is a multiple of p, we know it has hit a receptor. To determine which receptor it hit, we need to know if the ray hit the left (receptor 2) or the right wall (receptor 0 or 1).
 *     If the ray hits the right wall, and the total distance n*q is even, then it hits the receptor 0. Otherwise it hits receptor 1.
 */
public class MirrorReflection {

    public int mirrorReflection(int p, int q) {
        int n = 1;
        boolean left = false;
        while(true){
            if((n*q)%p == 0){
                // we have hit a receiver
                if(left){
                    return 2;
                }else{
                    // on right we have to decide
                    if((n*q/p) % 2 == 0) return 0;
                    return 1;
                }
            }else{
                left = left ? false : true;
                n++;
            }
        }
    }
}
