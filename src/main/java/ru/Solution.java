package ru;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

    class Solution {
        private static long timeStart;
        private static long timeEnd;

        public static String checkAvailability(List<String> schedule, String currentTime) {

            long convertCurrentTime = dateConverterToTime(currentTime);
            HashMap<Long, Long> maps = scheduleStartAndEndTime(schedule);

            for (Map.Entry<Long, Long> entry : maps.entrySet()) {
                timeStart = entry.getKey();
                timeEnd = entry.getValue();
                if (timeStart <= convertCurrentTime && timeEnd > convertCurrentTime) {
                    System.out.println(timeConverterToDate(timeEnd));
                    return timeConverterToDate(timeEnd);
                }
            }
            return "available";
        }

        public static void main(String[] args) {
            List<String> schedule = Arrays.asList("07:40-07:50", "07:50-08:00");
            checkAvailability(schedule, "07:45");
        }

        public static long dateConverterToTime(String currentTime) {
            long resultUnixTime = 0L;
            try {
                resultUnixTime = new SimpleDateFormat("HH:mm").parse(currentTime).getTime() / 1000;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return resultUnixTime;
        }


        public static String timeConverterToDate(long timeEnd) {
            return new SimpleDateFormat("HH:mm", Locale.UK).format(new Date(timeEnd * 1000L));

        }

        public static HashMap<Long, Long> scheduleStartAndEndTime(List<String> schedule) {
            Long timeBetween = 0L;
            Long timeBetween1 = 0L;
            HashMap<Long, Long> maps = new HashMap<>();
            String[] list;
            for (int i = 0; i < schedule.size(); i++) {
                String arrayElement = schedule.get(i);
                list = arrayElement.split("-");
                maps.put(dateConverterToTime(list[0]), dateConverterToTime(list[1]));
            }
            System.out.println(maps);
            for (Map.Entry<Long, Long> entry : maps.entrySet()) {
                timeStart = entry.getKey();
                timeEnd = entry.getValue();
                if(timeBetween.equals(timeStart)){
                    maps.clear();
                    maps.put(timeBetween1, timeEnd);
                }
                timeBetween = timeEnd;
                timeBetween1 = timeStart;
            }
            return maps;

        }
    }
