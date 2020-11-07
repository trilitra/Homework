//package ru;
//
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//class Solution {
//            public static String checkAvailability(List<String> schedule, String currentTime) {
//                Long unixTimeStart = null;
//                Long unixTimeEnd = null;
//                Long prevUnixEndTime = 0L;
//                String result = null;
//                Long convertedCurrentTime = dateConverterToTime(currentTime);
//                List<Map<Long, Long>> maps = parseScheduleInHashStartAndEndUnixTimes(schedule);
//                for (Map<Long, Long> map : maps) {
//                    for(Map.Entry<Long, Long> entry : map.entrySet()) {
//                        unixTimeStart = entry.getKey();
//                        unixTimeEnd = entry.getValue();
//                    }
//                    if (prevUnixEndTime.equals(unixTimeStart)) {
//                        result = timeConverterToDate(unixTimeEnd);
//                    } else {
//                        if (convertedCurrentTime > unixTimeStart && convertedCurrentTime < unixTimeEnd) {
//                            result = timeConverterToDate(unixTimeEnd);
//                            prevUnixEndTime = unixTimeEnd;
//                        } else {
//                            if (result == null) {
//                                return "available";
//                            }
//                        }
//                    }
//                }
//                return result;
//            }
//
//            public static void main(String[] args) {
//                List<String> listWithSchedule = Arrays.asList("09:30-10:15", "12:20-15:50");
//                checkAvailability(listWithSchedule, "11:00");
//            }
//
//            public static String timeConverterToDate(long unixTime) {
//                return new SimpleDateFormat("HH:mm", Locale.US).format(new Date(unixTime * 1000L));
//
//            }
//
//            public static Long dateConverterToTime(String date) {
//                Long resultUnixTime = 0L;
//                try {
//                    resultUnixTime = new SimpleDateFormat("HH:mm").parse(date).getTime() / 1000;
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                return resultUnixTime;
//            }
//
//            public static List<Map<Long, Long>> parseScheduleInHashStartAndEndUnixTimes(List<String> schedule) {
//                List<Map<Long, Long>> listWithHashMaps = new ArrayList<>();
//                schedule
//                        .forEach(item -> {
//                            Map<Long, Long> newHashMap = new HashMap<>();
//                            String[] startAndEndStringArray = item.split("-");
//                            newHashMap.put(dateConverterToTime(startAndEndStringArray[0]), dateConverterToTime(startAndEndStringArray[1]));
//                            listWithHashMaps.add(newHashMap);
//                        });
//                return listWithHashMaps;
//            }
//
//        }



