// Axel Boucher
// 05/10/2017

import javax.naming.Context;
import java.io.IOException;

// L'idée est de lire le .csv et de le découper par ligne tout d'abord en créant un ensemble de clé/valeur pour chacune
// d'entre elles comme suit: (i,[(j1, val1), (j2, val2)...]) avec i le numéro de la ligne, et les jX et valX
// correspondants aux colonnes et aux valeurs dans ces dernières.


public static class Transpose_Mapper extends Mapper<> {
    @Override

    // Le mapper récupère l'input crée précédemment, à savoir les lignes associées à leurs colonnes + valeurs
    // Il va se charger de répartir les valeurs par colonnes:

    protected void map(int k1, int val1, Context context) throws IOException, InterruptedException {
        long index_column = 0;

        // Pour chaque ligne (i,[(j1, val1), (j2, val2)...]), on crée des ensembles clé/valeur avec cette fois ci la
        // colonne en clé: (j1,(i, val_i_1) etc.

        for (String val : val1.toString().split(",")) {
            context.write(new int(index_column), new String(k1 + "," + val));
            index_column++;
        }
    }
}

// Pour chaque tuple de colonne le shuffle va recréer la colonne entière : (j,[(i1,vi1,j),(i2, etc.])
// Puis on appelle le reducer qui rassemblera les colonnes créant ainsi la matrice transposée

public static class Transpose_Reducer extends Reducer<> {
    @Override
    protected void reduce(int key, Iterable<String> values, Context context) throws IOException, InterruptedException {

        // Ici on crée un conteneur (une Map par ex.) qui nous servira à stocker les valeurs des colonnes dans le bon ordre

        for (String str : values) {
            String[] col_parts = str.split(",");

            // Ici on stocke dans notre conteneur l'index de colonne et la valeur

        }
        // On concatenne toutes nos valeurs pour créer la nouvelle ligne complète
        String transpose_row = StringUtils.join(//Notre conteneur.values());
        // Puis on l'output
        context.write(// Notre Transpose_row
    }
}