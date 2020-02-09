/*

Klarna bank Question
Problem statement
        You've been assigned to a task force aiming to develop a new generation of hard disk drives.
        One of the key components you will work on, is responsible for storing the data on the drive.

        We need of a function that can determine if a certain file
        can be stored in given a disk block in one chunk. In order to tell that there must be at least fileSize number of contiguous free disk sectors in a given block.

        You are given Set<Integer> occupiedSectors where each element is a sector between 1 and blockSize that is already occupied by some other data.
        The sectors are free to be written to otherwise.

        Return a boolean stating if it is possible to store the file in the given block.

        Although it is an early experimental development phase, please keep in mind that, it is undesired
        to have the so-far-excellent disk performance degraded by way-too-slow isWritable method execution.

        Input
        Method signature:

        boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors)

        Constraints:

        blockSize will be between 1 and 1,000,000, inclusive.
        fileSize will be between 1 and blockSize, inclusive.
        occupiedSectors will contain between 1 and 1,000,000 elements, inclusive.
        Each element of occupiedSectors will be between 1 and blockSize, inclusive.
        Elements of occupiedSectors will be distinct.
        Expected execution time is below 10 seconds.
        Output
        A boolean result telling if it is possible to store the file on a given disk block.

        Examples
        isWritable(1, 1, []) returns true as there is exactly 1 free sector which is enough to store the file of size 1
        isWritable(1, 1, [1]) returns false as there's no free disk space at all
        isWritable(4, 2, [1, 4]) returns true as the file of size 2 can be stored on sectors 2 and 3*/


package com.java10;

import java.util.*;

public class DiskSpace {

    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        return new DiskSpace().isWritableDisk(blockSize,fileSize,occupiedSectors);
    }

    public  boolean isWritableDisk(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        int availableSectors = blockSize-occupiedSectors.size() ;
        if(availableSectors<fileSize) {
            return false;
        }

        Set<Integer> freeSectors = new HashSet<>();
        for(int i =1;i<=blockSize;i++) {
            if(!occupiedSectors.contains(i)) {
                freeSectors.add(i);
            }
        }
        int length = longestConsecutive(freeSectors);
        if(length>=fileSize) {
            return true ;
        }
        return false;
    }

    public int longestConsecutive(Set<Integer> freeSectors) {
        int longestStreak = 0;
        for (int num : freeSectors) {
            if (!freeSectors.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (freeSectors.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }


}