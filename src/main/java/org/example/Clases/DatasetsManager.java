public class DatasetsManager implements TDALista {
    private TDALista DatasetsList;
    
    //ver de copiar métodos TDALista.

    public void CreateDataset(int id, String name, int size, String tipoProblema) {
        for (Dataset dataset : actual) {
           if (actual.getDato() == dataset.getDato()){
            System.out.println("Dataset ya existente");
           }
           else{
            lista.add(actual);
           }
        }
    }
    public Dataset SearchDataset(int id){
        for (Dataset actual : dataset) {
           if (actual.getId() == dataset.getId()){
            return dataset;
           }
        }
        System.out.println("No se encontró un dataset con Id = " + id);
    }
    public boolean DeleteDataset;
    public String PrintListAllDatasets;
}
