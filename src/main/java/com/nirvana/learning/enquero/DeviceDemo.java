package com.nirvana.learning.enquero;

import org.jetbrains.annotations.NotNull;

import java.util.*;

import static com.nirvana.learning.enquero.StatusConstants.*;

public class DeviceDemo {
    public static final List<Device> masterDevices = new ArrayList<>();

    public static void main(String[] args) {
        populateMasterDevices();
        Map<Integer, Device> incomingMap = getIncomingDevicesMap();
        Map<Integer, Map<Device, Status>> outgoingMap = getOutgoingMap(incomingMap);
        outgoingMap.forEach((key, value) -> System.out.println("Index: " + key + " - Device details: " + value.toString()));
    }

    //Get Outgoing Map
    @NotNull
    public static Map<Integer, Map<Device, Status>> getOutgoingMap(Map<Integer, Device> incomingMap) {
        Map<Integer, Map<Device, Status>> outgoingMap = new LinkedHashMap<>();
        Map<Device, Integer> deviceIndex = new LinkedHashMap<>();
        incomingMap.forEach((key, device) -> {
            String status;
            if (validateDevice(device)) {
                if (deviceIndex.containsKey(device)) {
                    status = DUPLICATE_DEVICE;
                } else {
                    status = VALID_DEVICE;
                }
                deviceIndex.put(device, key);
            } else {
                status = INVALID_DEVICE;
            }
            Map<Device, Status> deviceValidationStatus = new HashMap<>();
            deviceValidationStatus.put(device, new Status(status));
            outgoingMap.put(key, deviceValidationStatus);
        });
        return outgoingMap;
    }

    // Populate Devices in Master Collection
    public static void populateMasterDevices() {
        Device device1 = new Device("123", "ABC");
        Device device2 = new Device("124", "ABD");
        Device device3 = new Device("125", "ABE");
        Device device4 = new Device("126", "ABF");
        Device device5 = new Device("127", "ABG");
        Device device6 = new Device("128", "ABH");
        Device device7 = new Device("129", "ABI");
        masterDevices.add(device1);
        masterDevices.add(device2);
        masterDevices.add(device3);
        masterDevices.add(device4);
        masterDevices.add(device5);
        masterDevices.add(device6);
        masterDevices.add(device7);
    }

    //Get Incoming Devices
    public static Map<Integer, Device> getIncomingDevicesMap() {
        Device device1 = new Device("123", "ABC");
        Device device2 = new Device("124", "ABD");
        Device device3 = new Device("125", "ABE");
        Device device4 = new Device("123", "ABC");
        Device device5 = new Device("130", "ANC");
        Map<Integer, Device> incomingMap = new LinkedHashMap<>();
        incomingMap.put(1, device1);
        incomingMap.put(2, device2);
        incomingMap.put(3, device3);
        incomingMap.put(4, device3);
        incomingMap.put(5, device5);
        return incomingMap;
    }

    //Validate Devices
    public static boolean validateDevice(Device incoming) {
        return masterDevices.contains(incoming);
    }
}
