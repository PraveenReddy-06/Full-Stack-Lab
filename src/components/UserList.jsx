import React, { useEffect, useState } from "react";

const UserList = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then((res) => res.json())
      .then((data) => {
        setUsers(data);
        setLoading(false);
      })
      .catch(() => {
        setError("Error fetching users");
        setLoading(false);
      });
  }, []);

  return (
    <div>
      <h2>API Users</h2>
      {loading && <p>Loading...</p>}
      {error && <p>{error}</p>}
      {users.map((u) => (
        <div key={u.id}>
          <p>{u.name}</p>
          <p>{u.email}</p>
          <p>{u.phone}</p>
        </div>
      ))}
    </div>
  );
};

export default UserList;