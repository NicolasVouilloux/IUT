<?php
class Modele{
    public function get($attribut){
        return $this->$attribut;    
    }
    
    public function set($attribut,$valeur) {
        $this->$attribut = $valeur;
    }

    public function __constructor($donnees){
        if (!is_null($donnees)){
            foreach($donnees as $attribut => $valeur)
                $this->set($attribut,$valeur);
        }
    }
}

?>

