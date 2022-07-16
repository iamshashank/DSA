package com.company;

import com.company.arrays.*;
import com.company.backtracking.Google_MinimumKnightMove;
import com.company.backtracking.Google_PathWithMaxGold;
import com.company.backtracking.Hard_PalindromePartition;
import com.company.bfs.ArrayBFSTraversal;
import com.company.bfs.Google_HARD_SlidingPuzzle;
import com.company.bfs.Google_OperationToMakeNetworkConnected;
import com.company.bfs.WordLadder;
import com.company.bfs_priorityqueue.Google_PathWithMinEffort;
import com.company.bfs_priorityqueue.Google_SwimInRainWater;
import com.company.binarysearch.*;
import com.company.binarytree.*;
import com.company.design.Google_Design_DataStructiure_I;
import com.company.dfs.*;
import com.company.circular_tour.Hard_GasStation;
import com.company.gcd.Google_LargestNumber;
import com.company.graph.disjointset.EarliestMomentEveryOneBecameFriend;
import com.company.greedy.FarthestBuildingYouCanReach;
import com.company.greedy.MaximiseTopMostElementAfterKMove;
import com.company.greedy.MaximumBagsWithFullCapacityOfRocks;
import com.company.greedy_binarysearch.*;
import com.company.dbs_bfs_combined.AmazonRottenTomato;
import com.company.dbs_bfs_combined.K_HighestRankedItemByPrice;
import com.company.dbs_bfs_combined.ShortestBridge;
import com.company.dbs_bfs_combined.SumOfTreeDistances;
import com.company.dynamicprogramming.*;
import com.company.graph.InstallPackagesWithDependency;
import com.company.graph.disjointset.Google_MostStoneRemovedWithSameRowOrColumn;
import com.company.hash.*;
import com.company.hash_and_sorting.HandOfStraight;
import com.company.knapsack.Google_MinDiffBetweenServerLoad;
import com.company.knapsack.KnapSackRecursiveMemoization;
import com.company.knapsack.MaxSplitOfPositiveEvenIntergers;
import com.company.minimum_spanning_tree.MinimumSpanningTree;
import com.company.prefixtree_trie.Google_DistanceBetween2BinaryString;
import com.company.priorityqueue_heap.*;
import com.company.dqueue.SlidingWindowMaximum;
import com.company.slidingwindow.*;
import com.company.sorting.*;
import com.company.stack.*;
import com.company.string.*;
import com.company.two_pointer.ContainerWithMaxWater;
import com.company.wierd_searching.Search2DMatrix;
import com.company.dijakstra_single_source_shortest_path.NumberOfWaysToArriveAtDestination;
import com.company.dijakstra_single_source_shortest_path.PathWithMaxProbability;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        /*
        TreeSet<Integer> set = new TreeSet<>();
        set.remove(2);
        set.last(); // this will not remove the element
        set.first();
        set.pollFirst(); // this will remove the too
        set.headSet(2); // iterator of numbers of el strictly smaller than 2
        set.headSet(2).size(); // how many numbers strictly smaller than 2

        set.tailSet(2); //iterator for numbers greater or equal to 2
        set.tailSet(2).size(); // how many greater or equal to 2

        // this is same as TreeSet with map features
        // it sort wrt KEYS
        TreeMap<Integer, Integer> m = new TreeMap<>();
        m.ceilingKey(3); // least key  greater or equal to 3
        m.floorKey(3); // largest key less than or equal to 3
        m.get(3); // get the value same as map
        m.put(3, 3);
        m.firstKey(); // this will not remove from the map
        m.lastKey();
        m.pollFirstEntry(); // remove too

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(4);
        dq.add(1);
        dq.add(2);
        dq.add(5);
        System.out.println(dq);
        System.out.println(dq.peekFirst()+":"+dq.peekLast());
        dq.addFirst(100);
        dq.addLast(200);
        System.out.println(dq);

        */



	// write your code here
        System.out.println("LongestSubstringWithKUniqueCharacters = " + new LongestSubstringWithAtmost_K_UniqueCharacters().googledAlgo("aabacbebebenkwndkwndkwdndnwkabibiwufiow", 4));

        System.out.println("LongestSubstringWithoutRepeatingCharacter = " + new LongestSubstringWithoutRepeatingCharacter().process("geeksforgeeks"));
        System.out.println("LongestPalindromeSubstring = " + new LongestPalindromeSubstring().process("shabcbahj"));
        System.out.println("EggDroping = " + new EggDroping().process(8, 4));
        System.out.println("MinimumJumpToReachTheEnd = " + new MinimumJumpToReachTheEnd().process(new int[]{2,3,1,1,2,4,2,0,1,1}));
        System.out.println(new BathroomStalls().process(10, 3));
        System.out.println(new KClosestElementsInUnsorted().process(new int[]{2,4,5,1,6,7,2,4,5}, 3, 4));
        System.out.println(new RemoveKDigitsFromANumber().process("1419", 3));
        System.out.println(new RemoveKDigitsFromANumber().process("9824879284", 3));
        System.out.println(new RemoveKDigitsFromANumber().process("10", 2));
        System.out.println("___________remove K digits______");
        System.out.println(new RemoveKDigitsFromANumber().process("1432219", 3));
        System.out.println(new RemoveKDigitsFromANumber().process("9", 1));
        System.out.println(new RemoveKDigitsFromANumber().process("112", 1));
        System.out.println(new RemoveKDigitsFromANumber().process("10001", 4));
        System.out.println(new RemoveKDigitsFromANumber().process("11111111", 4));
        System.out.println(new RemoveKDigitsFromANumber().process("1234567890", 9));
        System.out.println("___________remove K digits______");
        System.out.println(new InstallPackagesWithDependency().setup());
        System.out.println(new GivenSomeOperationConvertString1IntoString2().process("Sunday", "Saturday", 6, 8));
        System.out.println(new FindNextGreaterElement().process(new int[]{1, 3, 4, 2}, new int[]{4,1,2}));
        System.out.println(new KnapSackRecursiveMemoization().process(new int[]{50, 140, 60}, new int[]{5, 20 ,10}, 2, 30));
        System.out.println(new KadaneContigousSubarrayWithLargestSum().process(new int[]{-2, -3, 4, -1,-2,1,5,-3}));
        System.out.println(new NumberOfSubarrayWithSumLessThanGivenSum().process(new int[]{2,5,6}, 10));
        System.out.println(new UniqueWaysToTraverseToEndOfMatrix().process(4,4));
        System.out.println(new GivenAlphabetMappingDecodeNumber().numDecodings("11106"));
        new MaxSplitOfPositiveEvenIntergers().process(12);
        new MaxSplitOfPositiveEvenIntergers().process(28);
        System.out.println(new LargestRectangleInHistogram().process(new int[]{2,1,5,6,2, 3 }));
        System.out.println(new MinimumCoinsToFormTotal().process(new int[]{7, 2, 3, 6}, 13));
        System.out.println(new MaxSizeRectangleOfAll1().setup());
        System.out.println(new LongestIncreasingSubsequence().process(new int[]{2,4,5,2,2,2,0,-1,1}));
        new BoxStackingToGetMaxHeight().setup();
        System.out.println(new MinimumCostForTickets().setup());
        System.out.println(new HandOfStraight().process(
                new int[]{9,13,15,23,22,25,4,4,29,15,8,23,12,19,24,17,18,11,22,24,17,17,10,23,21,18,14,18,7,6,3,6,19,11,16,11,12,13,8,26,17,20,13,19,22,21,27,9,20,15,20,27,8,13,25,23,22,15,9,14,20,10,6,5,14,12,7,16,21,18,21,24,23,10,21,16,18,16,18,5,20,19,20,10,14,26,2,9,19,12,28,17,5,7,25,22,16,17,21,11},
        10));
        System.out.println(Arrays.toString(new SortArrayInIncreasingFreqOfElements().process(new int[]{1,1,2,2,2,3,4})));
        System.out.println(new GoogleExpressiveWords().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(new LongestCommonSubsequenceIn2String().longestCommonSubsequence("abcafe", "acgrafv"));
        System.out.println(new MedianOfTwoSortedArray().findMedianSortedArrays(new int[]{1,2,3}, new int[]{4,5}));
        System.out.println(new Important_SplitArrayLargestSum().process(new int[]{7,2,5,10,8}, 2));
        System.out.println(new Important_SplitArrayLargestSum().process(new int[]{1, 4, 4}, 3));
        System.out.println(new Important_SplitArrayLargestSum().process(new int[]{2,3,1,1,1,1,1}, 5));
        System.out.println(new NumberOfRotationsOfSortedArray().process(new int[]{1,2,3,4,5}));
        System.out.println(new NoOfWaysToSplitArray().waysToSplitArray(new int[]{2,3,1,0}));
        System.out.println(Arrays.toString(new GoogleCampusBike().process(new int[][] { {0,0}, {1,1}, {2,0}}, new int[][]{ {1,0}, {2,2}, {2,1} })));
        System.out.println(new GoogleAccountBalancing().process(new int[][]{
                {0,1,10},
                {2,0,5}
        }));
        System.out.println(new GoogleAccountBalancing().process(new int[][]{
                {0,1,10},
                {1,0,1},
                {1,2,5},
                {2,0,5}
        }));
        System.out.println(new LCS_Google_ShortestWayToFromString().process("abc", "abcbc"));
        System.out.println(new LCS_Google_ShortestWayToFromString().process("abc", "acdbc"));
        System.out.println(new LCS_Google_ShortestWayToFromString().process("xyz", "xzyxz"));
        System.out.println(new Google_IncreasingTriplet().increasingTriplet(new int[]{4,5,2147483647,1,2}));
        System.out.println(new ShortestBridge().process(new int[][]{
                {0,1},{1,0}
        }));
//        System.out.println(new TeamRanking().rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"}));

        System.out.println(new TeamRanking().rankTeams(new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"}));
//        System.out.println(new RussianDollEnvelop().maxEnvelopes(new int[][]{{5,4},{6,7},{2,3},{2,1},{6,4}}));

        System.out.println(new RussianDollEnvelop().maxEnvelopes(new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}}));
        System.out.println(new LongestIncreasingSubsequence().fasterLIS(new int[]{1,7,8,4,5,6,-1,9}));
        System.out.println(new K_HighestRankedItemByPrice().highestRankedKItems(
                new int[][]{{1,2,0,1}, {1,3,0,1}, {0,2,5,1}},
                new int[]{2,5},
                new int[]{0,0},
                3
        ));
        System.out.println(new K_HighestRankedItemByPrice().highestRankedKItems(
                new int[][]{{1,2,0,1}, {1,3,3,1}, {0,2,5,1}},
                new int[]{2,3},
                new int[]{2,3},
                2
        ));
        System.out.println(new K_HighestRankedItemByPrice().highestRankedKItems(
                new int[][]{{1,1,1}, {0,0,1}, {2, 3, 4}},
                new int[]{2,3},
                new int[]{0,0},
                3
        ));
        System.out.println(new AmazonRottenTomato().orangesRotting(new int[][]{
                {2,1,1},{1,1,0},{0,1,1}
        }));
        System.out.println(new Google_MinimumKnightMove().process(2,1));
        System.out.println(new Google_MinimumKnightMove().process(5,5));
        System.out.println(new CountNodeWithHighestScore().countHighestScoreNodes(new int[]{-1,2,0,2,0}));
        System.out.println(new CountNodeWithHighestScore().countHighestScoreNodes(new int[]{-1,2,0}));
        System.out.println("_______");
        System.out.println(new CountNodeWithHighestScore().countHighestScoreNodes(new int[]{-1,3,3,5,7,6,0,0}));
        System.out.println(new Google_StringTransformsIntoAnotherString().process("leetcode", "codeleet"));
        System.out.println(new Google_StringTransformsIntoAnotherString().process("aabcc", "ccdee"));
        System.out.println(new Google_StringTransformsIntoAnotherString().process("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba"));
        System.out.println(new Google_MinSwapsToMakeArrayincreasing().minSwap(new int[]{1,3,5,4}, new int[]{1,2,3,7}));
        System.out.println(new Google_MinSwapsToMakeArrayincreasing().minSwap(new int[]{0,4,4,5,9}, new int[]{0,1,6,8,10}));
        System.out.println(new Google_MinSwapsToMakeArrayincreasing().minSwap(new int[]{
                1,1,2,4,5,10,11,9,11,20,21,24,22,27,24,25,35,37,39,30,32,34,35,46,38,39,40,41,43,45,62,66,68,69,54,73,57,58,59,60,79,63,64,70,86,77,79,95,83,86,105,90,91,92,95,96,97,98,99,126,128,104,108,131,133,118,138,120,124,127,130,131,132,133,136,141,160,145,148,149,150,166,167,156,162,172,165,166,168,169,170,171,185,187,188,189,178,179,181,183,198,199,190,203,193,207,195,197,198,201,202,203,216,207,218,229,210,211,236,214,215,240,220,224,231,235,236,257,239,260,263,244,271,247,248,250,251,255,257,291,260,302,263,264,267,269,309,271,272,316,319,276,321,278,279,280,284,285,337,289,344,294,346,348,300,351,352,353,305,357,359,311,362,363,364,365,367,369,323,372,373,332,335,336,384,386,387,388,343,346,395,348,352,353,407,409,362,412,414,417,376,420,379,422,381,382,383,384,385,386,388,389,441,444,396,397,400,401,402,457,408,459,416,418,470,421,482,429,431,432,433,438,497,440,441,444,447,450,506,452,456,458,459,518,466,520,470,522,472,473,527,478,480,531,482,534,537,491,492,542,496,497,500,548,551,504,507,558,512,561,562,520,522,525,526,572,529,532,533,534,535,536,537,539,542,544,545,592,593,548,549,550,551,554,555,557,558,559,613,564,565,569,624,625,573,575,577,578,635,584,639,643,644,589,648,594,651,652,599,602,603,605,607,669,610,611,677,616,618,689,624,691,627,628,697,630,633,634,635,636,637,712,640,720,722,643,724,645,650,731,653,656,658,742,663,666,670,671,748,750,751,681,683,756,759,689,762,692,693,696,767,699,774,702,778,706,783,708,711,791,715,716,801,719,720,721,722,723,724,813,816,817,821,825,827,733,829,742,833,750,835,752,753,758,759,760,845,846,847,776,778,854,856,784,786,788,864,792,794,795,797,800,805,878,813,817,886,887,888,830,892,833,895,836,839,844,845,907,850,911,912,853,858,860,920,922,868,869,870,875,933,877,878,937,885,888,890,945,895,901,948,949,907,909,913,914,957,959,921,924,925,964,965,967,969,972,939,975,976,945,981,982,953,955,957,992,961,963,965,967,968,1003,1005,974,1009,979,981,982,986,1021,989,991,993,994,1030,1032,1033,1036,1004,1005,1049,1008,1009,1011,1014,1060,1019,1063,1024,1025,1028,1068,1033,1034,1037,1076,1040,1079,1043,1045,1046,1050,1085,1054,1055,1060,1062,1063,1092,1068,1070,1071,1108,1075,1076,1077,1080,1081,1116,1085,1121,1122,1125,1090,1091,1094,1132,1136,1100,1102,1104,1145,1108,1149,1150,1152,1116,1117,1155,1123,1125,1162,1129,1134,1136,1138,1139,1143,1176,1148,1149,1150,1183,1187,1191,1194,1197,1198,1199,1200,1168,1169,1170,1206,1172,1212,1213,1178,1181,1218,1183,1184,1229,1232,1234,1237,1191,1242,1244,1199,1201,1248,1206,1209,1211,1215,1220,1261,1264,1268,1270,1229,1279,1283,1289,1290,1239,1292,1293,1249,1250,1297,1299,1253,1255,1256,1258,1312,1263,1264,1266,1322,1324,1275,1278,1330,1283,1289,1291,1342,1294,1297,1300,1353,1302,1355,1356,1307,1358,1360,1311,1312,1316,1319,1321,1369,1373,1325,1326,1376,1330,1332,1333,1334,1335,1336,1385,1341,1389,1390,1346,1347,1395,1350,1352,1353,1354,1409,1356,1358,1359,1361,1362,1363,1364,1434,1437,1368,1369,1372,1373,1443,1375,1376,1378,1448,1381,1450,1385,1456,1387,1458,1390,1395,1466,1402,1469,1404,1405,1406,1474,1410,1477,1416,1420,1423,1485,1426,1430,1432,1492,1434,1435,1439,1506,1510,1442,1515,1447,1452,1455,1457,1523,1463,1467,1529,1533,1473,1538,1539,1541,1486,1544,1545,1491,1492,1498,1553,1505,1556,1509,1559,1513,1515,1565,1517,1519,1520,1523,1573,1527,1581,1531,1532,1588,1589,1541,1591,1545,1597,1549,1550,1602,1552,1554,1557,1561,1563,1564,1568,1617,1571,1619,1573,1576,1583,1584,1587,1589,1593,1594,1597,1646,1600,1602,1604,1605,1655,1608,1609,1666,1612,1669,1672,1674,1622,1678,1625,1626,1628,1631,1632,1633,1634,1635,1642,1645,1646,1648,1696,1698,1701,1656,1660,1705,1707,1708,1666,1668,1669,1714,1715,1674,1675,1727,1728,1684,1685,1687,1689,1738,1739,1742,1705,1744,1711,1712,1713,1714,1754,1717,1719,1723,1724,1728,1730,1766,1733,1768,1769,1773,1747,1748,1753,1755,1756,1759,1760,1768,1769,1789,1778,1780,1781,1783,1795,1785,1787,1788,1789,1790,1791,1792,1793,1808,1796,1800,1802,1817,1818,1820,1812,1826,1828,1833,1817,1820,1821,1845,1825,1826,1828,1850,1832,1837,1838,1856,1844,1846,1847,1848,1849,1865,1852,1853,1869,1859,1875,1876,1877,1870,1880,1881,1875,1878,1881,1884,1885,1886,1889,1890,1899,1902,1895,1898,1900,1903,1911,1913,1917,1909,1920,1925,1926,1927,1928,1929,1930,1920,1932,1923,1925,1927,1929,1940,1932,1933,1946,1938,1940,1950,1952,1946,1948,1957,1952,1956,1957,1958,1959,1962,1963,1973,1965,1977,1975,1976,1981,1978,1984,1986,1983,1984,1986,1987,1989,1995,1992,1997,1999
        }, new int[]{
                0,2,5,6,8,7,8,13,15,13,15,21,26,23,28,34,26,27,28,40,41,42,45,36,49,50,51,57,58,59,46,47,48,52,70,56,75,76,77,78,62,80,84,85,71,88,94,80,97,101,88,106,107,112,114,116,118,124,125,101,102,129,130,116,117,135,119,143,144,146,147,149,152,154,157,159,144,161,162,163,164,152,155,169,171,164,173,177,179,181,182,183,174,175,176,177,190,193,195,196,184,185,202,192,205,194,208,209,210,211,212,213,206,217,208,209,233,234,212,237,239,217,242,247,248,249,250,238,259,240,243,268,246,272,274,277,283,287,288,258,295,261,303,304,306,308,270,312,313,273,274,320,277,324,328,329,330,333,286,342,290,345,298,299,350,301,302,303,356,307,310,360,313,315,317,318,320,322,370,330,331,374,375,380,338,339,340,341,392,393,347,399,400,402,357,359,411,368,369,374,419,377,421,380,423,426,428,431,435,436,437,440,391,392,449,450,451,454,456,407,458,409,460,467,420,473,422,486,487,490,494,496,439,499,501,503,504,505,451,510,511,512,513,465,519,468,521,471,524,526,475,529,530,481,532,483,490,538,540,493,545,546,547,501,503,552,557,508,559,516,518,564,566,569,571,527,573,576,577,578,579,581,584,585,588,589,590,546,547,594,597,598,603,605,607,608,609,610,563,614,616,621,570,571,626,630,631,634,582,638,585,587,588,646,592,650,597,598,656,657,658,666,667,609,673,674,612,680,683,622,690,626,695,696,629,705,706,707,708,709,711,639,718,641,642,723,644,726,728,651,732,733,741,660,744,745,746,747,675,676,679,754,755,685,686,761,690,763,764,765,698,770,701,777,703,782,707,785,788,712,795,797,717,804,806,808,809,810,811,726,728,729,730,731,732,828,738,830,743,834,751,836,837,839,842,844,766,768,774,848,853,780,781,859,860,862,791,866,867,868,872,873,876,811,881,883,818,824,826,889,832,893,834,897,898,905,906,849,908,851,852,914,918,919,865,866,924,928,929,930,876,934,936,882,940,942,944,891,946,947,902,904,950,952,954,955,916,917,961,962,963,927,929,932,935,936,973,941,943,979,948,952,983,987,989,960,995,996,999,1001,1002,972,973,1006,978,1010,1011,1013,1016,988,1022,1023,1024,1028,995,996,1000,1002,1045,1047,1006,1050,1051,1052,1055,1018,1062,1023,1064,1065,1066,1032,1070,1074,1075,1039,1078,1042,1080,1081,1082,1084,1051,1086,1087,1088,1089,1090,1067,1093,1094,1102,1072,1109,1111,1113,1114,1115,1084,1119,1086,1087,1088,1127,1129,1131,1095,1099,1137,1140,1143,1107,1148,1109,1113,1115,1153,1154,1120,1156,1159,1128,1164,1166,1167,1169,1173,1174,1146,1180,1181,1182,1152,1153,1154,1158,1161,1163,1164,1166,1201,1202,1203,1171,1207,1174,1177,1214,1216,1182,1223,1226,1186,1187,1188,1189,1239,1193,1198,1245,1246,1204,1249,1253,1254,1256,1260,1221,1222,1224,1225,1276,1232,1234,1235,1236,1291,1245,1247,1295,1296,1251,1252,1301,1302,1303,1306,1262,1315,1316,1318,1267,1270,1325,1327,1281,1334,1336,1339,1292,1345,1350,1351,1301,1354,1304,1306,1357,1308,1310,1361,1362,1363,1364,1366,1323,1324,1374,1375,1328,1377,1379,1380,1381,1382,1383,1337,1387,1344,1345,1391,1394,1349,1400,1403,1405,1406,1355,1416,1421,1422,1425,1426,1430,1433,1365,1366,1438,1439,1441,1442,1374,1444,1446,1447,1379,1449,1383,1455,1386,1457,1389,1463,1465,1399,1467,1403,1470,1472,1473,1409,1475,1415,1479,1482,1483,1425,1486,1490,1491,1433,1499,1500,1501,1440,1441,1513,1444,1516,1518,1520,1522,1459,1526,1528,1471,1472,1534,1476,1478,1483,1542,1487,1489,1548,1549,1550,1499,1555,1508,1558,1510,1560,1562,1516,1566,1567,1568,1572,1526,1577,1528,1582,1585,1533,1538,1590,1543,1592,1547,1598,1599,1551,1603,1606,1608,1611,1613,1614,1616,1569,1618,1572,1624,1627,1628,1629,1636,1637,1638,1639,1642,1598,1648,1650,1653,1654,1606,1660,1662,1611,1668,1614,1617,1618,1677,1624,1679,1680,1681,1682,1684,1685,1686,1687,1689,1690,1691,1695,1649,1654,1655,1702,1704,1661,1663,1664,1709,1712,1713,1671,1673,1718,1725,1682,1683,1731,1732,1735,1737,1691,1694,1700,1743,1706,1745,1748,1751,1752,1715,1755,1757,1761,1762,1763,1764,1731,1767,1736,1741,1743,1775,1776,1777,1779,1780,1781,1782,1783,1785,1772,1790,1792,1793,1794,1784,1796,1798,1799,1800,1801,1803,1805,1807,1794,1809,1812,1815,1803,1808,1809,1822,1813,1815,1816,1837,1843,1844,1823,1847,1848,1849,1830,1853,1854,1855,1843,1857,1860,1862,1863,1864,1851,1866,1868,1855,1872,1860,1864,1869,1878,1871,1872,1882,1884,1885,1887,1889,1893,1894,1897,1891,1894,1903,1904,1906,1910,1905,1906,1907,1918,1910,1911,1913,1914,1915,1918,1919,1931,1921,1934,1936,1937,1939,1931,1943,1945,1937,1947,1949,1942,1945,1954,1955,1951,1959,1960,1962,1964,1965,1967,1971,1964,1975,1974,1978,1980,1977,1982,1979,1980,1990,1991,1992,1993,1994,1991,1996,1994,1998
        }));
        System.out.println(new LongestCommonSubString().process("abcdefg", "bchefg"));
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "aa"));

        System.out.println(new Google_MinimimWindowSubsequence().process("abcdebdde", "bde"));
        System.out.println(
                Arrays.toString(new SumOfTreeDistances().optimised(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}}))
        );
        System.out.println(
                Arrays.toString(new SumOfTreeDistances().optimised(2, new int[][]{{1,0}}))
        );
        System.out.println(
                Arrays.toString(new SumOfTreeDistances().optimised(3, new int[][]{{2,1},{0,2}}))
        );
        System.out.println(new Google_BalancedTree_CountNumberOfTeams().numTeams(new int[]{2,5,1,3,4}));
        System.out.println(Arrays.toString(new Google_BraceExpansion().process("{a,b}c{d,e}f")));
        System.out.println(new WordLadder().process("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
        System.out.println(new WordLadder().process("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log"})));
        System.out.println(new WordLadder().process("log", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
        System.out.println(new WordLadder().process("hot", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
        System.out.println(new LexicographicallySmallestSubsequenceOfDistinctChar().smallestSubsequence("cbacdcbc"));
        System.out.println(new Google_MinAreaRectangle().minAreaRect(new int[][]{ {1,1},{1,3},{3,1},{3,3},{2,2} }));
        System.out.println(new FaultySensor().process(new int[]{2,3,4,5}, new int[]{2,1,3,4}));
        System.out.println(new FaultySensor().process(new int[]{2,2,2,2,2}, new int[]{2,2,2,2,5}));
        System.out.println(new FaultySensor().process(new int[]{2,3,2,2,3,2}, new int[]{2,3,2,3,2,7}));
        System.out.println(new Google_LicensekeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(new BackspaceStringCampare().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new MaxProductAfterKIncrement().heapSolution(new int[]{92,36,15,84,57,60,72,86,70,43,16}, 62));
        System.out.println(new FitSentencesOnScreen().process(new String[]{"hello", "world"}, 2, 8));
        System.out.println(new FitSentencesOnScreen().process(new String[]{"a", "bcd", "e"}, 3, 6));
        System.out.println(new FitSentencesOnScreen().process(new String[]{"I", "had", "apple", "pie"}, 4, 5));
        System.out.println(new Google_MaximiseTheBeautyOfGarden().process(new int[]{100,1,1,-3,1}));
        System.out.println(new Google_MaximiseTheBeautyOfGarden().process(new int[]{-1,-2,0,-1}));
        System.out.println(new BurstBalloons().maxCoins(new int[]{1,4,6,1,3,7,8,9,23,11,5}));
        System.out.println(new Google_MostStoneRemovedWithSameRowOrColumn().removeStones(new int[][]{ {0,1},{1,2},{1,3},{3,3},{2,3},{0,2} } ));
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
        String encode = new Google_EncodeDecodeString().encode(new String[]{"abcd", "efghi", "12345", "1qws"});
        System.out.println(encode);
        System.out.println(Arrays.toString(new Google_EncodeDecodeString().decode(encode)));
        System.out.println(new Google_ConfusingNumberII().process(10));
        System.out.println(new Google_ConfusingNumberII().process(20));
        System.out.println(new Google_ConfusingNumberII().process(100));
        System.out.println(new Google_PathWithMaxGold().getMaximumGold(new int[][]{{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}}));
        Google_UniqueWordAbbriviation goo = new Google_UniqueWordAbbriviation();
        goo.process(new String[]{"deer", "door", "cake", "card"});
        System.out.println(goo.checkIfUniqueAbb("deer"));
        System.out.println(goo.checkIfUniqueAbb("cart"));
        System.out.println(goo.checkIfUniqueAbb("cane"));
        System.out.println(goo.checkIfUniqueAbb("make"));
        System.out.println(new CrackingTheSafe().crackSafe(2,6));
        System.out.println(new VerifyInOrderSerialization().preOrder("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new DivideChocolate().process(new int[]{1,2,3,4,5,6,7,8,9}, 5));
        System.out.println(new DivideChocolate().process(new int[]{1,2,3,4,2,3}, 5));
        System.out.println(new DivideChocolate().process(new int[]{1,2,3,4,2,3}, 7));
        List<List<Integer>> ll = new ArrayList<>();
        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(1); aa.add(2); aa.add(3); aa.add(4); aa.add(5); aa.add(6);
        ll.add(aa);
        System.out.println(Arrays.toString(new ArrayBFSTraversal().findDiagonalOrder(ll)));
//        System.out.println(new ApiRateLimiter().process());
        System.out.println("---");
        System.out.println(new ReorderDataInLog().reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}));
        System.out.println(new Search2DMatrix().searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        System.out.println(new ContainerWithMaxWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new MinNumOfArrowToBurstAllBaloon().findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(new MeetingRoomII().process(new int[][]{{1,4}, {2,4}, {3,5}, {4,5}}));
        System.out.println(new MeetingRoomII().sweepLine(new int[][]{{1,4}, {2,4}, {3,5}, {4,5}}));
        System.out.println(new BuySellStockWithCooldown().maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(new HARD_BestTimeToSellStock_III().maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(new BuySellStockWithTransactionFee().maxProfit(new int[]{1,2,3,0,2}, 2));
        System.out.println(new EASY_BuySellStock().maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(new UniqueBST().numTrees(5));
        System.out.println(new UniqueBST().countTreesRec(5));
        System.out.println(new Hard_PalindromePartition().partition("abba"));
        new AllPossiblePartitionOfString().process("abba");
        System.out.println(new PalindromePartition().process("abcbm"));
        // inbuilt binary search
        int[] v = new int[]{10,20,30,40,50};
        System.out.println(Arrays.binarySearch(v, 45));
        System.out.println(new DifferentWaysToAddParenthesis().diffWaysToCompute("2*3-4*5"));
        System.out.println(new MaximiseTopMostElementAfterKMove().maximumTop(new int[]{5,2,2,4,0,6}, 4));
        System.out.println(new PrisonCellAfterNDays().prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7));
        System.out.println(new Hard_GasStation().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(new Google_KokoEatingBanana().minEatingSpeed(new int[]{1,2,5,3,6,7}, 4));
        System.out.println(new Koko_MinimizeMaxProductDistributedToAnyStore().minimizedMaximum(4, new int[]{1,2,5,3,6,7}));
        System.out.println(new FarthestBuildingYouCanReach().furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
        System.out.println(new KthLargestElement().findKthLargest(new int[]{3,2,1,5,6,4}, 5));
        System.out.println(new EarliestMomentEveryOneBecameFriend().findMoment(new int[][]{
                {20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5} },
        6));
        System.out.println(new MinimumSpanningTree().minCostConnectPoints(new int[][]{ {2,-3},{-17,-8},{13,8},{-17,-15} }));
        System.out.println(new GroupAnagram().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(new Amazon_FamilyLoginCount().countFamilyLogins(new String[]{"bag", "cbh", "sfe", "red", "cbh"}));
        System.out.println(new Amazon_FamilyLoginCount().countLogins(new String[]{"bag", "cbh", "sfe", "red", "cbh"}));
        System.out.println(new Google_MinDiffBetweenServerLoad().serverLoad(new int[]{2,7,4,1,8,1}));
        System.out.println(new Google_MinDiffBetweenServerLoad().serverLoad(new int[]{31,26,33,21,40}));
        System.out.println(new Google_MinDiffBetweenServerLoad().serverLoadDP(new int[]{2,7,4,1,8,1}));
        System.out.println(new Google_MinDiffBetweenServerLoad().serverLoadDP(new int[]{31,26,33,21,40}));
        System.out.println(new Google_LargestNumber().largestNumber(new int[]{1,3,5,6,7}, 2));
        System.out.println(new Google_TimeToTypeAString().timeTaken("abcdefghijklmnopqrstuvwxy", "cba"));
        System.out.println(new Google_NumOfChairsAtParty().chairsNeeded(new int[]{1, 2, 6, 5, 3}, new int[]{5, 5, 7, 6, 8}));
        System.out.println(new Google_NumOfChairsAtParty().sweepMethod(new int[]{1, 2, 6, 5, 3}, new int[]{5, 5, 7, 6, 8}));
        System.out.println(new NumberOfWaysToArriveAtDestination().countPaths(7, new int[][]{
                {0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}
        }));
        System.out.println(new Google_OperationToMakeNetworkConnected().makeConnected(6, new int[][]{ {0,1},{0,2},{0,3},{1,2},{1,3} }));
        System.out.println(new Google_OddEvenJump().oddEvenJumps(new int[]{10,13,12,14,15}));
        System.out.println(new Google_UniqueEmailAddress().numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(new Google_FruitsIntobasket().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
        System.out.println(new Google_MinDayToMake_M_Bouquets().minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
        System.out.println(new PathWithMaxProbability().maxProbability(3, new int[][]{ {0,1},{1,2},{0,2} }, new double[]{0.5,0.5,0.2},0 ,2));
        System.out.println(new Hard_CountServerThatCommunicate().countServers(new int[][]{ {0,0,0,0},{1,1,1,1},{0,0,0,1},{0,0,1,1},{0,0,0,1} }));
        new Google_MagicSquareOdd().process(5);
        System.out.println(new Google_NumberOfDecreasingSubsequence().decreasingSubsequence(new int[]{5, 2, 4, 3, 1, 6}));
        System.out.println(new Google_NumberOfDecreasingSubsequence().ldsSplit(new int[]{5, 2, 4, 3, 1, 6}));
        System.out.println(new Google_DistanceBetween2BinaryString().findLength(new String[]{ "1011100", "1011011","1001111" }));
        System.out.println(new Google_DistanceBetween2BinaryString().findLength(new String[]{ "10", "11" }));

        System.out.println(new Google_DistanceBetween2BinaryString().findLength(new String[]{ "1011100", "1011100","101" }));
        System.out.println(new Google_DistanceBetween2BinaryString().findLength(new String[]{ "1011000", "1011110","1011" }));
        System.out.println(new MaximumBagsWithFullCapacityOfRocks().maximumBags(new int[]{2,3,4,5}, new int[]{1,2,4,4}, 2));
        System.out.println(Arrays.toString(new Google_NearestStore().findStores(new int[]{5,10,17}, new int[]{1, 5, 20, 11, 16})));
        System.out.println(Arrays.toString(new Google_NearestStore().findStores(new int[]{2,4,2}, new int[]{5, 3, 1, 2})));
        new Google_LowerUpperBoundBinarySearch().process(new int[]{4, 6, 10, 12, 18, 20}, 6);
        new Google_LowerUpperBoundBinarySearch().process(new int[]{4, 6, 10, 12, 18, 20}, 20);
        new Google_LowerUpperBoundBinarySearch().process(new int[]{4, 6, 10, 12, 18, 20}, 4);
        System.out.println(Arrays.toString(new Google_AmountOfAreaPaintedEachDay().paint(new int[][]{ {4,7}, {1,3}, {2,7} })));
        System.out.println(Arrays.toString(new Google_AmountOfAreaPaintedEachDay().paint(new int[][]{ {4,10}, {7,13}, {20,30} })));
        System.out.println(new CalculatorII().calculate(" 3+5 / 2 "));
        System.out.println(new Google_EvaluatePostfixExpression().evaluatePostFix(new String[]{"1", "1", "2", "+", "-" }));
        // HEAP SORT, MERGE SORT, RADIX SORT, complexity, lookup complexity
        System.out.println(new Google_CallSchedule().processA(new String[]{"A", "B", "C", "D"}, new int[][]{ {1,10}, {5,7}, {6,12}, {15,17} }, 9));
        System.out.println("----");
        new Google_CallSchedule().processB(new String[]{"A", "B", "C", "D"}, new int[][]{ {1,7}, {7,10}, {6,12}, {15,17} });
        new Google_HARD_WierdBinarytree().setup();
        new Google_BigIntegerAsArray().setup();
        System.out.println(new Google_PathWithMinEffort().minimumEffortPath(new int[][]{ {1,2,3},{3,8,4},{5,3,5} }));
        System.out.println(new Google_SwimInRainWater().swimInWater(new int[][]{ {0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6} }));
        System.out.println(new Google_SortOnlyLowerChar_In_Place().process("Test@123 Google"));
        System.out.println(new Google_LongestSubstring_EveryCharacterHasEqualOccurence().longestSubstring("aabbccmedf"));
        System.out.println(new Google_Day_WhenAPathExists().findDay(4, 4, new int[][]{ {1,1}, {1,2}, {2,2}, {2,3}, {3,3}, {3,0}, {0, 1}, {0,0} }));
        new Google_PhotosClientOrderedStream().setup();
        System.out.println();
        System.out.println(new Google_PatientQueue().process(2, new int[][]{{1, 8}, {1, 2}, {6, 4}}));
        System.out.println(new Google_EvaluateReversePolishNotation().evaluate(new String[]{ "b", "5", "=", "a", "b", "=", "a", "5", "+" }));
        System.out.println(new Google_HARD_SlidingPuzzle().slidingPuzzle(new int[][]{ {4,1,2},{5,0,3} }));
        System.out.println();
        System.out.println(new Google_CountRoomsInCircularStreet().process(new int[]{ 1,1,1,1,0,0,0,1,0,1,0,0,0,1 }));
        System.out.println(Arrays.toString(new Google_SortWeightIn_N_Boxes().sort(new int[]{ 2,4,1,6,7,3,5,0 })));
        System.out.println(new Google_Max_Points_From_Cards().maxScore(new int[]{1,2,3,4,5,6,1}, 3));
        System.out.println(new Google_CustomerWaitTime().waitTime(2, 4, new int[]{4,5}));
        new Google_Design_DataStructiure_I().setup();
        new Google_Generate_5by5_Game().generateGame();
        new Google_DeleteLeafNode().setup();
        new Google_ReturnAllRootToNodePath().setup();
        System.out.println(new Google_StringMath().getChar("abcd", 3));
        System.out.println(new Google_StringMath().getChar("abcd", 12));
        System.out.println(new Google_VerifyTheRules().checkIfValid(
                new String[]{"P1 N P2", "P2 S P3", "P1 E P3", "P3 NW P4", "P5 SW P4", "P1 W P5", "P1 NW P3"}
        ));
        System.out.println(new Google_VerifyTheRules().checkIfValid(
                new String[]{"P1 N P2", "P2 S P3", "P1 E P3", "P3 NW P4", "P5 SW P4", "P1 W P5"}
        ));
        System.out.println(new Google_VerifyTheRules().checkIfValid(
                new String[]{"P1 N P2", "P2 N P3", "P1 S P3"}
        ));
        System.out.println(new Google_VerifyTheRules().checkIfValid(
                new String[]{"P1 N P2", "P2 N P3", "P3 S P1"}
        ));
        new Google_MaxSumPathOf_K_Length().setup();
        System.out.println(Arrays.toString(new Easy_IntersectionOf2Array().intersection(new int[]{1,2,2,1}, new int[]{2, 2})));
        System.out.println(new Easy_IntersectionOf2Array().optimised(new int[]{4, 5, 9}, new int[]{4, 4, 8, 9, 9}));
        System.out.println(new Google_PartitionString().partition("232387421", 2, 3));
        System.out.println(new Google_PartitionString().partition("232387421431445", 3, 3));
//        "2323|87|421|431|445"
//        "2323|87421|431445"
//        "2323|87421431|445"
//        "232387|421431|445"
//        "232387|421|431445"
//        "232387421|431|445"

        System.out.println(new Google_CountPair_satisfying_condition().process(new int[]{3,2,6,5,1,6}, new int[]{6,1,2,1,5,7}, 1, 1));
        System.out.println(new HouseRobber().rob(new int[]{2,7,9,3,1}));
    }
}
