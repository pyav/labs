/**
 * https://leetcode.com/problems/design-parking-system/
 *
 * Output:
 * ------
 * true
 * true
 * false
 * false
 */

import java.util.Map;
import java.util.HashMap;

class ParkingSystem {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public ParkingSystem(int big, int medium, int small) {
        map.put(1, big);
        map.put(2, medium);
        map.put(3, small);
    }

    public boolean addCar(int carType) {
        switch(carType) {
            case 1:
                    return (map.get(1)>0 && map.put(1, map.get(1)-1)>0)? true: false;
            case 2:
                    return (map.get(2)>0 && map.put(2, map.get(2)-1)>0)? true: false;
            case 3:
                    return (map.get(3)>0 && map.put(3, map.get(3)-1)>0)? true: false;
            default:
                    return false;
        }
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }

}

