import React, { useEffect, useState } from "react";
import axios from "axios";

const FakePostList = () => {
  const [posts, setPosts] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [category, setCategory] = useState("all");

  const fetchPosts = async () => {
    try {
      const res = await axios.get("https://dummyjson.com/posts");
      setPosts(res.data.posts);
      setFiltered(res.data.posts);
    } catch {
      alert("Error fetching posts");
    }
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  const handleFilter = (value) => {
    setCategory(value);
    if (value === "all") {
      setFiltered(posts);
    } else {
      setFiltered(posts.filter((p) => p.userId === Number(value)));
    }
  };

  return (
    <div>
      <h2>Fake API Posts</h2>

      <button onClick={fetchPosts}>Refresh</button>

      <select onChange={(e) => handleFilter(e.target.value)}>
        <option value="all">All</option>
        <option value="1">User 1</option>
        <option value="2">User 2</option>
        <option value="3">User 3</option>
      </select>

      {filtered.map((p) => (
        <div key={p.id}>
          <h4>{p.title}</h4>
          <p>{p.body}</p>
        </div>
      ))}
    </div>
  );
};

export default FakePostList;