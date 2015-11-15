# SHFragmentManager
A simple fragment manager to help you easy to change fragment
If you use this repository you don't need to think show or hide fragment and you don't need to think the manager how to work.You only need to "choose" or "replace".

##Usage

```
dependencies {
    compile 'com.smallsoho.shfragmentmanager:library:1.0.0'
}
```

##Sample Code

Use it is very easy

- New a object

```
SohoFragmentManager fragmentManager;
```

- Init it

```
fragmentManager = new SohoFragmentManager(getSupportFragmentManager(), R.id.fragment_container);
```

- Init your fragment

```
one = new FragmentOne();
two = new FragmentTwo();
three = new FragmentThree();
```

- You have four methods to change fragment

```
fragmentManager.replace("one"); //replace by a tag
fragmentManager.replace(one);  //replace by a fragment object
fragmentManager.choose("one"); //change by a tag
fragmentManager.choose(one);  //change by a fragment object
```

PS: The "replace" will Re-take the life cycle but the "choose" not.

- You can add a fragment to the manager

```
fragmentManager.addFragment(one, "one");
```

**PS: Don't make the different fragment use the same name in one manager.It will destory this manager.**

In one manager,it have a list to save fragment and its tag.
Every fragment in the list have a tag.
if you give a tag to a fragment,it will save it.
Or the fragment's tag is the index of it in list.

- You also can remove a fragment from the manager int two ways

```
fragmentManager.removeFragment(one);
fragmentManager.removeFragment("one");
```
**PS:If the fragment or the tag is not in the manager,it will do nothing.**

- If you will not use a manager,please destroy it

```
fragmentManager.destroy();
```

##License

    Copyright 2013 Andreas Stuetz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.