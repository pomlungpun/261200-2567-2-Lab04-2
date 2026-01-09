public class HealthRecord {
    private int height;
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    // Static fields for statistics
    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT;

    // TODO: Add static fields for counter and average
    private static int counter = 0;
    private static double averageHeight = 0.0;

    public HealthRecord(int height) {
        // Increment counter when a new object is created
        counter++;
        setHeight(height);
    }

    public void setHeight(int height) {
        // TODO: 2 Check if the input height falls within the permitted range
        // Note: Updated to >= and <= to include the boundary values (50 and 175)
        if (height <= MAX_PERMITTED_HEIGHT && height >= MIN_PERMITTED_HEIGHT) {
            this.height = height;
        } else {
            this.height = DEFAULT_HEIGHT;
        }

        // TODO: 3 Update the tallest and shortest height
        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }

        // TODO: Update setHeight to calculate average height
        // Formula: New Average = ((Old Average * Old Count) + New Height) / New Count
        // Note: Since we incremented counter in the constructor, (counter - 1) is the Old Count.
        double previousTotalHeight = averageHeight * (counter - 1);
        averageHeight = (previousTotalHeight + this.height) / counter;
    }

    public int getHeight() {
        return this.height;
    }

    public static int getTallestHeight() {
        return HealthRecord.tallestHeight;
    }

    public static int getShortestHeight() {
        return HealthRecord.shortestHeight;
    }

    // TODO: Add a static getter getAverageHeight
    public static double getAverageHeight() {
        return HealthRecord.averageHeight;
    }

    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }

    // TODO: Update displayClassDetails to display averageHeight
    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.println("The average height (cm): " + getAverageHeight());
        System.out.println("Total records: " + counter); // Optional: good for debugging
    }
}