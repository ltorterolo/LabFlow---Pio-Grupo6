public class ModelsManager implements TDALista {
    private TDALista ModelsList;
    
    //ver de copiar métodos TDALista.

    public void CreateModel(int id, String name, String modelType, String associatedParameters) {
        for (Modelo model : actual) {
           if (actual.getDato() == model.getDato()){
            System.out.println("Modelo ya existente");
           }
           else{
            lista.add(actual);
           }
        }
    }
    public Modelo SearchModel(int id){
        for (Modelo actual : model) {
           if (actual.getId() == model.getId()){
            return model;
           }
        }
        System.out.println("No se encontró un modelo con Id = " + id);
    }
    public boolean DeleteModel;
    public String PrintListAllModels;
}
