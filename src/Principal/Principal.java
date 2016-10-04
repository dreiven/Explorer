package Principal;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import java.awt.Toolkit;
import Utils.*;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.event.TreeExpansionEvent;

public class Principal extends JFrame  {

	 
	 JTree explorador;
	 DefaultMutableTreeNode Raiz;
	
	 
	 public Principal(){

	 setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspace\\Explorer\\Imagenes\\folder.png"));
      this.setTitle("EXPLORADOR");
	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  Raiz=new DefaultMutableTreeNode("Raiz");
	  explorador=new JTree(Raiz);
	  explorador.addTreeWillExpandListener(new TreeWillExpandListener() {
	  	public void treeWillCollapse(TreeExpansionEvent event) {
	  	}
	  	public void treeWillExpand(TreeExpansionEvent event) {
	  		DefaultTreeCellRenderer render=(DefaultTreeCellRenderer)explorador.getCellRenderer();
	  		Icon folderopn = Utils.escalar_Imagen("/Imagen/carpeta.png",10);
	  	  render.setOpenIcon(folderopn);
	  	  Icon folder2 = Utils.escalar_Imagen("/Imagen/carpeta2.png",10);
	  	  render.setClosedIcon(folder2);
	  	}
	  });
	
	  DefaultTreeCellRenderer render=(DefaultTreeCellRenderer)explorador.getCellRenderer();
	
	 // Icon folderclsd =  Obtener_Imagenes.escalar_Imagen("/Imagen/folder.png",10);
	  //render.setLeafIcon(folderclsd);
	  Icon folderopn = Utils.escalar_Imagen("/Imagen/carpeta.png",10);
	  render.setOpenIcon(folderopn);
	  Icon folder2 = Utils.escalar_Imagen("/Imagen/carpeta2.png",10);
	  render.setClosedIcon(folder2);
	
	  explorador.addTreeSelectionListener(new TreeSelectionListener(){


	   public void valueChanged(TreeSelectionEvent e) {
	    try{
	    DefaultMutableTreeNode sel=(DefaultMutableTreeNode)explorador.getLastSelectedPathComponent();
	    agregarHijos(sel);
	    for(int i=0;i<sel.getChildCount();i++){
	     DefaultMutableTreeNode nieto=(DefaultMutableTreeNode)sel.getChildAt(i);
	     File fhijo=obtenerRuta(sel);
	     agregarHijos(nieto);
	    }
	    }catch(NullPointerException npe){
	     
	    }
	   }
	   
	  });
	  
	  for(int i=0;i<File.listRoots().length;i++){
	   DefaultMutableTreeNode hijo=new DefaultMutableTreeNode(File.listRoots()[i]);
	   Raiz.add(hijo);
	  }  
	  getContentPane().add(new JScrollPane(explorador));
	 }
	 
	 public void agregarHijos(DefaultMutableTreeNode padre) throws NullPointerException{
	  if(padre!=Raiz){
	   File fpadre=obtenerRuta(padre);
	   if(fpadre.isDirectory()){
	    for(int i=0;i<fpadre.list().length;i++){
	     DefaultMutableTreeNode hijo=new DefaultMutableTreeNode(fpadre.list()[i]);
	     padre.add(hijo);
	    }
	   }
	  }
	 }
	 
	 public File obtenerRuta(DefaultMutableTreeNode p){
	  String ruta="";
	  for(int i=0;i<p.getPath().length-1;i++){
	   ruta=ruta+p.getPath()[i+1]+"\\";
	  }
	  File f=new File(ruta);
	  return f;
	 }
	
	
	
	
	
	
}
