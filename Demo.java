import java.util.*;

class Process {
    int processId;
    int arrivalTime;
    int burstTime;
    int waitingTime;
    int turnaroundTime;

    Process(int processId, int arrivalTime, int burstTime) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }
}

public class FCFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        // Create an array of processes
        Process[] processes = new Process[n];

        // Input arrival time and burst time for each process
        for (int i = 0; i < n; i++) {
            System.out.println("Enter arrival time and burst time for process " + (i + 1) + ":");
            int arrivalTime = scanner.nextInt();
            int burstTime = scanner.nextInt();
            processes[i] = new Process(i + 1, arrivalTime, burstTime);
        }

        // Sort the processes based on arrival time
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        // Calculate waiting time and turnaround time for each process
        int totalWaitingTime = 0;
        for (Process process : processes) {
            process.waitingTime = totalWaitingTime;
            process.turnaroundTime = process.waitingTime + process.burstTime;
            totalWaitingTime += process.burstTime;
        }

        // Calculate average waiting time
        double averageWaitingTime = (double) totalWaitingTime / n;

        // Print the schedule and average waiting time
        System.out.println("\nFCFS Scheduling:");
        System.out.println("Process\tArrival Time\tBurst Time\tWaiting Time\tTurnaround Time");
        for (Process process : processes) {
            System.out.println(process.processId + "\t\t" + process.arrivalTime + "\t\t\t" + process.burstTime +
                    "\t\t\t" + process.waitingTime + "\t\t\t" + process.turnaroundTime);
        }
        System.out.println("\nAverage Waiting Time: " + averageWaitingTime);

        scanner.close();
    }
}
