let contenu_du_main = {
   tag       : 'main',
   attributs : [ ['class','joli'] ],
   fils      : [
      {
         tag       : 'h1',
         attributs : [],
         fils      : [
            { texte : 'titre un' }
         ]
      },      
      {
         tag       : 'section',
         attributs : [],
         fils      : [ 
            {
               tag       : 'article',
               attributs : [],
               fils      : [ 
                  {
                     tag       : 'h2',
                     attributs : [],
                     fils      : [ 
                        { texte : 'titre deux' }
                     ]
                  },
                  {
                     tag       : 'p',
                     attributs : [],
                     fils      : [
                        { texte : 'paragraphe un' }
                     ]
                  },
                  {
                     tag       : 'p',
                     attributs : [],
                     fils      : [
                        { texte : 'paragraphe deux' }
                     ]
                  },
               ]
            },
            {
               tag       : 'article',
               attributs : [ ['class','attention'] ],
               fils      : [ 
                  {
                     tag       : 'p',
                     attributs : [],
                     fils      : [
                        { texte : 'paragraphe trois' }
                     ]
                  },
               ]
            },
         ]
      },      
   ]
};