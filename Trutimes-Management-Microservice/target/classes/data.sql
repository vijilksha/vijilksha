INSERT INTO employee (id, name, email, role, manager_id) VALUES (1, 'John Doe', 'john.doe@company.com', 'MANAGER', NULL);
INSERT INTO employee (id, name, email, role, manager_id) VALUES (2, 'Jane Smith', 'jane.smith@company.com', 'EMPLOYEE', 1);
INSERT INTO employee (id, name, email, role, manager_id) VALUES (3, 'Alice Johnson', 'alice.johnson@company.com', 'EMPLOYEE', 1);
INSERT INTO employee (id, name, email, role, manager_id) VALUES (4, 'Bob Brown', 'bob.brown@company.com', 'EMPLOYEE', 1);
INSERT INTO employee (id, name, email, role, manager_id) VALUES (5, 'Charlie Williams', 'charlie.williams@company.com', 'EMPLOYEE', 1);

INSERT INTO time_entry (id, date, swipe_in, swipe_out, top_up_minutes, approved, employee_id)
VALUES (1001, '2025-04-19', '2025-04-19T09:00:00', '2025-04-19T18:00:00', 0, false, 2);

INSERT INTO time_entry (id, date, swipe_in, swipe_out, top_up_minutes, approved, employee_id)
VALUES (1002, '2025-04-18', '2025-04-18T09:30:00', '2025-04-18T17:30:00', 30, false, 3);

INSERT INTO time_entry (id, date, swipe_in, swipe_out, top_up_minutes, approved, employee_id)
VALUES (1003, '2025-04-17', '2025-04-17T08:45:00', '2025-04-17T17:00:00', 45, true, 4);

INSERT INTO time_entry (id, date, swipe_in, swipe_out, top_up_minutes, approved, employee_id)
VALUES (1004, '2025-04-16', '2025-04-16T09:15:00', '2025-04-16T19:00:00', 0, true, 5);

INSERT INTO time_entry (id, date, swipe_in, swipe_out, top_up_minutes, approved, employee_id)
VALUES (1005, '2025-04-15', '2025-04-15T09:00:00', '2025-04-15T18:00:00', 0, false, 2);
