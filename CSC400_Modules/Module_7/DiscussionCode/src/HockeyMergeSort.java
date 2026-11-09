    class Team {
        String name;
        int points;

        public Team(String name, int points) {
            this.name = name;
            this.points = points;
        }

        @Override
        public String toString() {
            return name + ": " + points + " points";
        }
    }

    public class HockeyMergeSort {

        public static void mergeSort(Team[] teams) {
            if (teams.length <= 1) {
                return;
            }

            int middle = teams.length / 2;

            Team[] left = new Team[middle];
            Team[] right = new Team[teams.length - middle];

            for (int i = 0; i < middle; i++) {
                left[i] = teams[i];
            }

            for (int i = middle; i < teams.length; i++) {
                right[i - middle] = teams[i];
            }

            mergeSort(left);
            mergeSort(right);

            merge(teams, left, right);
        }

        public static void merge(Team[] teams, Team[] left, Team[] right) {
            int leftIndex = 0;
            int rightIndex = 0;
            int teamIndex = 0;

            while (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex].points >= right[rightIndex].points) {
                    teams[teamIndex] = left[leftIndex];
                    leftIndex++;
                } else {
                    teams[teamIndex] = right[rightIndex];
                    rightIndex++;
                }
                teamIndex++;
            }

            while (leftIndex < left.length) {
                teams[teamIndex] = left[leftIndex];
                leftIndex++;
                teamIndex++;
            }

            while (rightIndex < right.length) {
                teams[teamIndex] = right[rightIndex];
                rightIndex++;
                teamIndex++;
            }
        }

        public static void main(String[] args) {

            Team[] teams = {
                    new Team("Avalanche", 82),
                    new Team("Stars", 77),
                    new Team("Wild", 74),
                    new Team("Jets", 77),
                    new Team("Blues", 65),
                    new Team("Predators", 58)
            };

            System.out.println("Original Standings:");
            for (Team team : teams) {
                System.out.println(team);
            }

            mergeSort(teams);

            System.out.println("\nSorted Standings:");
            for (Team team : teams) {
                System.out.println(team);
            }
        }
    }