import java.util.*;

class Computer {
    private String assetTag;
    private boolean isOccupied;

    public Computer(String assetTag) {
        this.assetTag = assetTag;
        this.isOccupied = false;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        isOccupied = true;
    }

    public void vacate() {
        isOccupied = false;
    }

    @Override
    public String toString() {
        return "[" + (isOccupied ? "X" : " ") + "]";
    }
}

class ComputerLab {
    private Computer[][] layout;

    public ComputerLab(int rows, int columns) {
        layout = new Computer[rows][columns];
        initializeLayout();
    }

    private void initializeLayout() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                layout[i][j] = new Computer("");
            }
        }
    }

    public void addComputer(int row, int column, String assetTag) {
        if (isValidPosition(row, column)) {
            layout[row][column] = new Computer(assetTag);
        }
    }

    public void removeComputer(int row, int column) {
        if (isValidPosition(row, column)) {
            layout[row][column] = new Computer("");
        }
    }

    public void displayLayout() {
        for (Computer[] row : layout) {
            for (Computer computer : row) {
                System.out.print(computer);
            }
            System.out.println();
        }
    }

    private boolean isValidPosition(int row, int column) {
        return row >= 0 && row < layout.length && column >= 0 && column < layout[0].length;
    }
}

public class ClassroomLabLayout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows in the computer lab: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns in the computer lab: ");
        int columns = scanner.nextInt();

        ComputerLab lab = new ComputerLab(rows, columns);

        while (true) {
            System.out.println("\n1. Add computer");
            System.out.println("2. Remove computer");
            System.out.println("3. Display lab layout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the row and column to add a computer (e.g., 1 2): ");
                    int addRow = scanner.nextInt();
                    int addColumn = scanner.nextInt();
                    System.out.print("Enter the asset tag for the computer: ");
                    String assetTag = scanner.next();
                    lab.addComputer(addRow, addColumn, assetTag);
                    break;
                case 2:
                    System.out.print("Enter the row and column to remove a computer (e.g., 1 2): ");
                    int removeRow = scanner.nextInt();
                    int removeColumn = scanner.nextInt();
                    lab.removeComputer(removeRow, removeColumn);
                    break;
                case 3:
                    lab.displayLayout();
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
