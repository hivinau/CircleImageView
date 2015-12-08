# CircleImageView
<h1>This project is for free use. It deals with custom imageview that crop an image to a rounded shape.</h1>
<br>
<h2>Use it only on xml file layout.</2>
<br>
<p>Replace for example :</p>
<br>
<p>&lt;Imageview</p>
<p>android:layout_width="source_width" </p>
<p>android:layout_height="source_height" </p> 
<p>android:scaleType="centerCrop" </p>
<p>android:contentDescription="@null" </p>
<p>android:src="your_source"/&gt; </p>
<br>
<p>By :</p>
<br>
<p>&lt;fr.futurdigital.apps.android.circleimageview.CircleImageView</p>
<p>android:layout_width="source_width" </p>
<p>android:layout_height="source_height" </p>
<p>android:contentDescription="@null" </p>
<p>android:src="your_source" </p>
<p>custom:fill_color="#FFF"/&gt; </p>
<br>
<p>Note : has only one custom attribut to set on xml -&gt; if image is too small, we fill empty space with color chosen</p>
<p>See result : </p>
![alt tag](http://s29.postimg.org/peudkq8c7/result.png)
