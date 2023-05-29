import java.util.*;

public class Shop {
    private Set<Notebook> notebooks;

    public Shop() {
        notebooks = new HashSet<>();
    }

    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    public List<Notebook> filterNotebooks(Map<String, Object> filters) {
        List<Notebook> result = new ArrayList<>();

        for (Notebook notebook : notebooks) {
            boolean satisfiesFilter = true;

            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String criteriaName = entry.getKey();
                Object criteriaValue = entry.getValue();
                
                switch (criteriaName) {
                    case "ram":
                        int ram = (int) criteriaValue;
                        if (notebook.getRam() < ram) {
                            satisfiesFilter = false;
                        }
                        break;

                    case "hddSize":
                        int hddSize = (int) criteriaValue;
                        if (notebook.getHddSize() < hddSize) {
                            satisfiesFilter = false;
                        }
                        break;

                    case "os":
                        String os = (String) criteriaValue;
                        if (!notebook.getOs().equalsIgnoreCase(os)) {
                            satisfiesFilter = false;
                        }
                        break;

                    case "color":
                        String color = (String) criteriaValue;
                        if (!notebook.getColor().equalsIgnoreCase(color)) {
                            satisfiesFilter = false;
                        }
                        break;
                }
            }

            if (satisfiesFilter) {
                result.add(notebook);
            }
        }

        return result;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }
}